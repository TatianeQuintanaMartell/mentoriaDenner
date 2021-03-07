package TestCases;

import Framework.TestBaseWeb;
import Tasks.RegisterTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarRegistroTestCaseWeb extends TestBaseWeb {
    private WebDriver driver = this.pegarDriver();
    RegisterTask registerTask = new RegisterTask(driver);

    @Test
    public void realizarRegistroComSucesso(){
        registerTask.preencherInformacoesObrigatorias();
        registerTask.preencherInformacoesNaoObrigatorias();
        registerTask.clicarNobotaosubmit();
    }

    @Test
    public void realizarRegistroFaltandoInformaçõesObrigatorias(){
        registerTask.preencherInformacoesNaoObrigatorias();
        registerTask.clicarNobotaosubmit();
        registerTask.validarMensagemDePreenchimentoDeCampoObrigatorio();
    }
}
