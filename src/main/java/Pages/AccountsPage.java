package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    // 1. Locators
    By linkaccountSections = By.xpath("//*[@id='center_column']//span");

    //Constructor for Accounts page
    public AccountsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getAccountPageTitle()
    {
        return driver.getTitle();
    }

    public int getAccountSectionCount()
    {
        System.out.println(driver.findElements(linkaccountSections).size());
        return driver.findElements(linkaccountSections).size()-1;

    }
    public List<String> getAccountSections()
    {
        List<String> accountSections = new ArrayList<>();
        List <WebElement> accountsHeaders = driver.findElements(linkaccountSections);
        for (WebElement accountHeader:accountsHeaders)
        {
            String e = accountHeader.getText();
            accountSections.add(e);
        }
        return accountSections;
    }




}
