package Validations;

import Framework.FileOperation;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ValidCepValidations {

    public static void validateResponse(Response response,String[] fields) {
        for(String field : fields){
            validateData(field,response);
        }
    }

    public static void validateData(String dataToValidate, Response response){
        Assertions.assertEquals(FileOperation.getProperties("response").getProperty(dataToValidate),
                response.then().extract().path(dataToValidate));
    }
}
