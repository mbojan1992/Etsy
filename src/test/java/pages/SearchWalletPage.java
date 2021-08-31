package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchWalletPage extends BaseHelper
{
    // Test Case 4
    // Searching wallet for men.

    @FindBy(id = "global-enhancements-search-query")
    WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"gnav-search\"]/div/div[1]/button/span")
    WebElement magnifierIcon;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[3]/div/div/button")
    WebElement heart;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul")
    WebElement walletLists;

    WebDriver driver;

    public SearchWalletPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void clickOnSearchBar()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("welcome-message-text")));
        searchBar.click();
    }
    private void enterTermInSearchBar(String term)
    {
        searchBar.sendKeys(term);
    }
    private void clickOnMagnifierIcon()
    {
        magnifierIcon.click();
    }
    private void clickOnHeart()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[3]/div/a/div[1]/div/div/div/div/div/img")));
        heart.click();
    }
    private void clickOnSomeWallet()
    {
        wdWait.until(ExpectedConditions.visibilityOf(walletLists));
        List<WebElement> wallets = walletLists.findElements(By.className("wt-list-unstyled"));
        WebElement wl = wallets.get(2);
        System.out.println("");
        System.out.println("Chosen wallet is: " + wl.getText());
        wl.click();
    }
    public void searchWallet(String term)
    {
        clickOnSearchBar();
        enterTermInSearchBar(term);
        clickOnMagnifierIcon();
        clickOnHeart();
        clickOnSomeWallet();
    }
}
