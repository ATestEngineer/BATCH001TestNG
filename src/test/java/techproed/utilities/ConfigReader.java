package techproed.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key){

        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis); //data akışını objeye yükledik
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return properties.getProperty(key);
    }

     /*
    Bu method icinde olusturdugumuz Properties objectine key verdigimiz zaman
    bize vermis oldugumuz key in configuration.properties dosyasindaki value sunu
    return edecek
     */


}
