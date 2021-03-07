package Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBaseWeb extends DriverManager{

    private static WebDriver driver;
    private static FileOperation fileOperation = new FileOperation();

    public static WebDriver pegarDriver(){
        driver = setDriver(TypeDriver.CHROME);
        return driver;
    }

    @BeforeEach
    public void iniciar(){
        pegarDriver().get(fileOperation.getProperties("url").getProperty("url"));
    }

    @AfterEach
    public void terminar(){
        fecharDriver();
    }

}
