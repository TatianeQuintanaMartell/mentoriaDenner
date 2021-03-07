package Framework;

public class DataClass {

    public static Object[][] cepvalido(){
        FileOperation.setProperties("cep","cepasertestado", "01001000");
        return new Object[][]{{"01001000"}};
    }

    public static Object[][] cepinexistente(){
        FileOperation.setProperties("cep","cepasertestado", "99999999");
        return new Object[][]{{"99999999"}};
    }
    public static Object[][] cepcomformatoinvalido(){
        FileOperation.setProperties("cep","cepasertestado", "999999xx");
        return new Object[][]{{"999999xx"}};
    }

    protected static final String BASE_URI = "https://viacep.com.br";
    protected static String cep = FileOperation.getProperties("cep").getProperty("cepASerTestado");
    protected static String basePath = "/ws/"+cep+"/json/";
}
