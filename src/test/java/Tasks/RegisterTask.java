package Tasks;

import Framework.FakersGenerator;
import Framework.FileOperation;
import Framework.Utils;
import Framework.Waits;
import PageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterTask {
    private static WebDriver driver;
    private static Waits waits;
    private static RegisterPage registerPage;
    private static FakersGenerator fakersGenerator;
    private Utils utils;

    public RegisterTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        registerPage = new RegisterPage(this.driver);
        fakersGenerator = new FakersGenerator();
        utils = new Utils();
    }

    public void preencherInformacoesObrigatorias(){
        registerPage.getFirstName().sendKeys(fakersGenerator.getFirstName());
        registerPage.getLastName().sendKeys(fakersGenerator.getLastName());
        registerPage.getEmail().sendKeys(fakersGenerator.getEmail());
        registerPage.getPhone().sendKeys(fakersGenerator.getPhone());
        registerPage.getGender().click();
        registerPage.getICountry().isSelected();
        utils.selecionarTexto("Country", registerPage.getICountry());
    }

    public void preencherInformacoesNaoObrigatorias(){
        registerPage.getAddress().sendKeys(fakersGenerator.getAddress());
        registerPage.getHobbiesCricket().click();
        registerPage.getHobbiesMovies().click();
        registerPage.getHobbiesHockey().click();
        registerPage.getLanguages().click();
        registerPage.getLanguagesSpanish().click();
        registerPage.getSkills().isSelected();
        utils.selecionarTexto("Skills", registerPage.getSkills());
        registerPage.getDateOfBirthYear().isSelected();
        utils.selecionarTexto("DateOfBirthYear", registerPage.getDateOfBirthYear());
        registerPage.getDateOfBirthMonth().isSelected();
        utils.selecionarTexto("DateOfBirthMonth", registerPage.getDateOfBirthMonth());
        registerPage.getDateOfBirthDay().isSelected();
        utils.selecionarTexto("DateOfBirthDay", registerPage.getDateOfBirthDay());
        registerPage.getPassword().sendKeys(fakersGenerator.getPassword());
        registerPage.getConfirmPassword().sendKeys(FileOperation.getProperties("dadosDeEntradaParaoTeste").getProperty("Password"));
    }

    public void clicarNobotaosubmit(){
        registerPage.getButtonSubmit().click();
    }

    public void validarMensagemDePreenchimentoDeCampoObrigatorio(){

    }
}
