package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

   private WebDriver driver;
   //1. Locators by By class
   private By emailId = By.id("email");
   private By password = By.id("passwd");
   private By SignInButton = By.id("SubmitLogin");
   private By forgotPasswordLink = By.linkText("Forgot your password?");

   // 2. Constructor for login-page
   public LoginPage(WebDriver driver)
   {
      this.driver = driver;
   }

   //3. Action Method for locators
   public String getLoginPageTitle()
   {
      return driver.getTitle();
   }

   public boolean isForgotPasswordLinkExist()
   {
      return driver.findElement(forgotPasswordLink).isDisplayed();
   }

   public void enterUserName(String username)
   {
      driver.findElement(emailId).sendKeys(username);
   }
   public void enterPassword(String pwd)
   {
      driver.findElement(password).sendKeys(pwd);
   }

   public void clickSignBtn()
   {
      driver.findElement(SignInButton).click();
   }

}
