package stepDefinitions;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginPageSteps {

   private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
   private static String Title;
   private static String homePage_title;

   @Given("user is on login page")
   public void user_is_on_login_page() {
      DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
   }
   @When("user gets the title of the page")
   public void user_gets_the_title_of_the_page() {
      Title = loginPage.getLoginPageTitle();
      System.out.println("Page title is" + Title);
   }
   @Then("page title should be {string}")
   public void page_title_should_be(String expectedTitle) {
      Assert.assertEquals(Title, expectedTitle);
   }

   @Then("forgot your password link should be displayed")
   public void forgot_your_password_link_should_be_displayed() {
      Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
   }

   @When("user enters username {string}")
   public void user_enters_username(String username) {
      loginPage.enterUserName(username);
   }
   @When("user enters password {string}")
   public void user_enters_password(String password) {
      loginPage.enterPassword(password);
   }
   @When("user clicks on Login button")
   public void user_clicks_on_login_button() {
      loginPage.clickSignBtn();
   }






}
