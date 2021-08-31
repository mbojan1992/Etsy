package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HandmadeUmbrellaPage extends BaseHelper
{
    // Test Case 8
    // Add "handmade umbrella" to cart.

    @FindBy(id = "global-enhancements-search-query")
    WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"gnav-search\"]/div/div[1]/button/span")
    WebElement magnifierIcon;
    @FindBy(id = "search-filter-button")
    WebElement filter;
    @FindBy(xpath = "/html/body/div[8]/div[3]/div/div/div[1]/div[3]/form/div/div[1]/div[2]/fieldset/div/div/div[1]/div/label")
    WebElement freeShipping;
    @FindBy(xpath = "/html/body/div[8]/div[3]/div/div/div[2]/button[2]")
    WebElement applyButton;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/div[4]/div[5]/div[3]/div[6]/div[2]/div[3]/div/button")
    WebElement sortBy;
    @FindBy(xpath = "//*[@id=\"sortby\"]/div/a[3]")
    WebElement highestPrice;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[1]/div/a/div[1]/div/div/div/div/div/img")
    WebElement umbrella;

    WebDriver driver;

    public HandmadeUmbrellaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   private void clickOnSearch()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("welcome-message-text")));
        searchBar.click();
    }
    private void enterHandmadeUmbrella(String term)
     {
         searchBar.sendKeys(term);
     }
     private void clickOnMagnifierIcon()
     {
         magnifierIcon.click();
     }
     private void clickOnAllFilters()
     {
         wdWait.until(ExpectedConditions.visibilityOf(filter));
         filter.click();
     }
     private void selectFreeShipping()
     {
         wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-height-full"), "Filters"));
         freeShipping.click();
     }
     private void clickOnApplyButton()
     {
         wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[8]/div[3]/div/div/div[2]/button[2]")));
         applyButton.click();
     }
     private void clickOnSortByButton()
     {
         wdWait.until(ExpectedConditions.visibilityOf(sortBy));
         sortBy.click();
     }
     private void chooseHighestPrice()
     {
         wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-menu__item"), "Highest Price"));
         highestPrice.click();
     }
     private void clickOnUmbrella()
     {
         wdWait.until(ExpectedConditions.elementToBeClickable(umbrella));
         umbrella.click();

     }

    public void handmadeUmbrella(String term)
    {
        clickOnSearch();
        enterHandmadeUmbrella(term);
        clickOnMagnifierIcon();
        clickOnAllFilters();
        selectFreeShipping();
        clickOnApplyButton();
        clickOnSortByButton();
        chooseHighestPrice();
        clickOnUmbrella();
    }
}
