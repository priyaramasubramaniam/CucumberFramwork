package stepDefinitions;

import Factory.DriverFactory;
import Pages.AccountsPage;
import Pages.LoginPage;
import com.beust.ah.A;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;
    @Given("User has already login to the Application")
    public void user_has_already_login_to_the_application(DataTable dataTable) {
        List<Map<String, String>> credDetails = dataTable.asMaps();
        String username = credDetails.get(0).get("Username");
        String password = credDetails.get(0).get("Password");
        DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(username, password);
    }
    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String accountPageTitle = accountsPage.getAccountPageTitle();
        System.out.println(accountPageTitle);
    }
    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List <String> expAccountSectionsList = sectionsTable.asList();
        System.out.println(expAccountSectionsList);
        List <String> actAccountSectionsList = accountsPage.getAccountSections();
        System.out.println(actAccountSectionsList);
        Assert.assertEquals(expAccountSectionsList, actAccountSectionsList);
    }
    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedCount) {
        Assert.assertTrue(accountsPage.getAccountSectionCount()==expectedCount);
    }
}
