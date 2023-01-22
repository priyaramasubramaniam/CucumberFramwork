package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
   private Properties prop;

   /*
   This method is used to load properties from config.properties
    */
   public Properties init_props()
   {
      prop = new Properties();
      try {
         FileInputStream fis = new FileInputStream("src/test/resources/Configs/config.properties");
         prop.load(fis);
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return prop;
   }

}
