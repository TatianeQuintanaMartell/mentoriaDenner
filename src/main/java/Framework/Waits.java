package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private WebDriver driver;

    public Waits (WebDriver driver){
        this.driver = driver;
    }

    public WebElement esperarVisibilidadeDoElemento(By by){
        WebDriverWait espera = new WebDriverWait(driver,15);
        return espera.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement esperarCarregarElemento(WebElement elemento){
        try {
            return new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(elemento));

        }catch (WebDriverException e){
            return elemento;
        }
    }
}
