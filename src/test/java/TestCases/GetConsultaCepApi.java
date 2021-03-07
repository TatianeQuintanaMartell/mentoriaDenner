package TestCases;

import Framework.TestBaseApi;
import Validations.ValidCepValidations;
import io.qameta.allure.Description;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;

public class GetConsultaCepApi extends TestBaseApi {

    private final String[] FIELDS = {"cep","logradouro"};

    @Description("Teste de Contrato")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepvalido")
    public void realizarTesteDeContrato(String cepValido){
        Response payload =
                given()
                    .log().all()
                    .spec(requestSpecification)
                .when()
                    .get("/ws/"+cepValido+"/json/")
                .then()
                    .log().body()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

        payload.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema.json"));
    }

    @Description("Consulta de cep válido")
    @ParameterizedTest
    @MethodSource("Framework.DataClass#cepvalido")
    public void consultarCepValido(String cepValido){
        Response response =
                given()
                    .spec(requestSpecification)
                .when()
                    .get("/ws/"+cepValido+"/json/")
                .then()
                    .log().body()
                    .statusCode(200)
                    .extract().response();

        ValidCepValidations.validateResponse(response, FIELDS);
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
