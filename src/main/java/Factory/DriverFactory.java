package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

   public WebDriver driver;
   public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

   public WebDriver init_driver(String browser) {
      System.out.println("browser value is" + browser);
      if (browser.equals("chrome")) {
         WebDriverManager.chromedriver().setup();
         tldriver.set(new ChromeDriver());
      } else if (browser.equals("firefox")) {
         WebDriverManager.firefoxdriver().setup();
         tldriver.set(new FirefoxDriver());
      } else {
         System.out.println("Please pass correct browser");
      }
      getDriver().manage().deleteAllCookies();
      getDriver().manage().window().maximize();
      return getDriver();
   }

   /*
   This is used to get driver with ThreadLocal
    */
   public static synchronized WebDriver getDriver() {
      return tldriver.get();
   }


}
