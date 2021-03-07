package Framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseApi {
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    protected static final String BASE_URI = "https://viacep.com.br";

    @BeforeAll
    public static void setUpUrlCep(){
        buildRequestSepc();
        buildResponseSpec();
    }

    private static void buildRequestSepc(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
    }

    private static void buildResponseSpec(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .build();
    }



}
