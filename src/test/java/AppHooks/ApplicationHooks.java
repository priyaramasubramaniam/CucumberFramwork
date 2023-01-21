package AppHooks;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
   private ConfigReader configReader;
   private WebDriver driver;
   private Properties prop;
   private DriverFactory driverFactory;
   @Before(order =0)
   public void getProperty()
   {
      configReader = new ConfigReader();
      prop = configReader.init_props();
   }

   @Before(order = 1)
   public void launchBrowser()
   {
      String browserName = prop.getProperty("browser");
      driverFactory = new DriverFactory();
      driver = driverFactory.init_driver(browserName);
   }

   @After(order=0)
   public void quitBrowser()
   {
      driver.quit();
   }

   @After(order = 1)
   public void tearDown(Scenario scenario)
   {
      if(scenario.isFailed())
      {
         //Take Screenshot
         String ScreenShotName = scenario.getName().replaceAll(" ", "_");
         byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(sourcePath, "image/png", ScreenShotName);
      }
   }
}
