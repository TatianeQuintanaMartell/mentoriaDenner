package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private Waits waits;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getFirstName(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
    }
    public WebElement getLastName(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input"));
    }
    public WebElement getAddress(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));
    }
    public WebElement getEmail(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"eid\"]/input"));
    }
    public WebElement getPhone(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input"));
    }
    public WebElement getGender(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input"));
    }
    public WebElement getHobbiesCricket(){
        return waits.esperarVisibilidadeDoElemento(By.id("checkbox1"));
    }
    public WebElement getHobbiesMovies(){
        return waits.esperarVisibilidadeDoElemento(By.id("checkbox2"));
    }
    public WebElement getHobbiesHockey(){
        return waits.esperarVisibilidadeDoElemento(By.id("checkbox3"));
    }
    public WebElement getLanguages(){
        return waits.esperarVisibilidadeDoElemento(By.id("msdd"));
    }
    public WebElement getLanguagesSpanish(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[35]/a"));
    }
    public WebElement getSkills(){
        return waits.esperarVisibilidadeDoElemento(By.id("Skills"));
    }
    public WebElement getICountry(){
        return waits.esperarVisibilidadeDoElemento(By.id("countries"));
    }
    public WebElement getDateOfBirthYear(){
        return waits.esperarVisibilidadeDoElemento(By.id("yearbox"));
    }
    public WebElement getDateOfBirthMonth(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
    }
    public WebElement getDateOfBirthDay(){
        return waits.esperarVisibilidadeDoElemento(By.id("daybox"));
    }
    public WebElement getPassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("firstpassword"));
    }
    public WebElement getConfirmPassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("secondpassword"));
    }
    public WebElement getButtonSubmit(){
        return waits.esperarVisibilidadeDoElemento(By.id("submitbtn"));
    }


}
