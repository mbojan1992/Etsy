package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseHelper
{

    // Test Case 2
    // Log in on "https://www.etsy.com/" site.

    @FindBy(xpath = "/html/body/div[3]/header/div[4]/nav/ul/li[1]/button")
    WebElement SignIn;
    @FindBy(id = "join_neu_email_field")
    WebElement enterEmail;
    @FindBy(name = "submit_attempt")
    WebElement clickOnContinue;
    @FindBy(id = "join_neu_password_field")
    WebElement enterPassword;
    @FindBy(name = "submit_attempt")
    WebElement clickOnSigIn;

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToSite()

    {
        driver.get("https://www.etsy.com/");
    }

    private void clickOnSignInButton()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/header/div[4]/nav/ul/li[1]/button")));
        //clickOnSignInButton.click();
        js.executeScript("arguments[0].click();", SignIn);

    }

    private void enterEmailAddress(String email)
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("join_neu_email_field")));
        enterEmail.sendKeys(email);
    }

    private void clickOnContinueButton()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit_attempt")));
        clickOnContinue.click();
        //js.executeScript("arguments[0].click();", clickOnContinue);
    }

    private void enterPasswordInField(String password)
    {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("join_neu_password_field")));
        enterPassword.sendKeys(password);
    }

    private void clickOnSignIn()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit_attempt")));
        clickOnSigIn.click();
        //js.executeScript("arguments[0].click();", clickOnSigIn);
    }

    public void login(String email, String password)
    {
        navigateToSite();
        clickOnSignInButton();
        enterEmailAddress(email);
        clickOnContinueButton();
        enterPasswordInField(password);
        clickOnSignIn();
    }
}
