package TestCases;

import Framework.FileOperation;
import Framework.TestBaseApi;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;

public class GetConsultaCepApi extends TestBaseApi {

    @Description("Teste de Contrato")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepvalido")
    public void realizarTesteDeContrato(String cepValido){
        Response response =
                given()
                    .spec(requestSpecification)
                .when()
                    .get(cepValido)
                .then()
                    .log().body()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema.json"))
                    .extract().response();
    }

    @Description("Consulta de cep válido")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepvalido")
    public void consultarCepValido(String cepValido){
        Response response =
                given()
                    .spec(requestSpecification)
                .when()
                    .get(cepValido)
                .then()
                    .log().body()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

        String cep = response.then().extract().path("cep");
        String logradouro = response.then().extract().path("logradouro");
        String complemento = response.then().extract().path("complemento");
        String bairro = response.then().extract().path("bairro");
        String localidade = response.then().extract().path("localidade");
        String uf = response.then().extract().path("uf");
        String ibge = response.then().extract().path("ibge");
        String gia = response.then().extract().path("gia");
        String ddd = response.then().extract().path("ddd");
        String siafi = response.then().extract().path("siafi");

        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("cep"),cep);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("logradouro"),logradouro);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("complemento"),complemento);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("bairro"),bairro);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("localidade"),localidade);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("uf"),uf);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("ibge"),ibge);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("gia"),gia);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("ddd"),ddd);
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty("siafi"),siafi);

    }

    @Description("Consulta de Cep inexistente")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepinexistente")
    public void consultarCepInexistente(String cepInexistente){
        Response response =
                given()
                    .spec(requestSpecification)
                .when()
                    .get(cepInexistente)
                .then()
                    .log().body()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
        Boolean validaResponse = response.then().extract().path("erro");
        Assertions.assertEquals(true, validaResponse);
    }

    @Description("Consulta de Cep com formato inválido")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepcomformatoinvalido")
    public void consultarCepComFormatoInvalido(String cepComFormatoInvalido){
        given()
              .spec(requestSpecification)
        .when()
              .get(cepComFormatoInvalido)
        .then()
              .log().body()
              .assertThat()
              .statusCode(400);
    }
}
