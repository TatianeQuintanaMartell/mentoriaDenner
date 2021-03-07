package Framework;

public class DataClass {

    public static Object[][] cepvalido(){
        FileOperation.setProperties("cep","cepasertestado", "01001000");
        return new Object[][]{{"01001000"},{"91786280"}};
    }

    public static Object[][] cepinexistente(){
        FileOperation.setProperties("cep","cepasertestado", "99999999");
        return new Object[][]{{"99999999"}};
    }
    public static Object[][] cepcomformatoinvalido(){
        FileOperation.setProperties("cep","cepasertestado", "999999xx");
        return new Object[][]{{"999999xx"}};
    }


}
