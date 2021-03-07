package Framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utils {
    private Select select;

    public void selecionarTexto(String properties, WebElement webElement){
        select = new Select(webElement);
        select.selectByVisibleText(FileOperation.getProperties("dadosDeEntradaParaoTeste").getProperty(properties));
    }

    /*public static void setCepASerTestado (String cep){
        String cepASerTestado = FileOperation.getProperties("cep").getProperty(cep);
        FileOperation.setProperties("cep","cepasertestado", cepASerTestado);
    }*/

}
