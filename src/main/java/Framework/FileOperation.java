package Framework;

import java.io.*;
import java.util.Properties;

public class FileOperation {

    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir")+
            File.separator +"src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "Properties" + File.separator;

    public static Properties getProperties(String fileName){

        InputStream inputStream = null;
        Properties properties = new Properties();

        try {
            File file = new File(DIR_PATH_PROPERTIES + fileName + ".properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        }

        catch (IOException e){
            System.out.println("Arquivo de Propriedades não encontrado");
            e.printStackTrace();
        }
        return properties;

    }

    public static void setProperties(String fileName, String propKey, String propValue)  {
        Properties properties = getProperties(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties");
            properties.setProperty(propKey,propValue);
            properties.store(outputStream,null);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
