package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ToysAndEntertainmentPage extends BaseHelper
{
    // Test Case 6
    // Select some filters for video games.

    @FindBy(id = "catnav-primary-link-11049")
    WebElement clickAndHoldToysAndEntertainment;
    @FindBy(id = "catnav-l4-11060")
    WebElement clickOnVideoGames;
    @FindBy(name = "free_shipping")
    WebElement freeShipping;
    @FindBy(id = "shop-location-input-1")
    WebElement europe;
    @FindBy(id = "ship_to_select")
    WebElement shipTo;

    WebDriver driver;

    public ToysAndEntertainmentPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void clickAndHoldToysAndEntertainment()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("welcome-message-text")));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickAndHoldToysAndEntertainment);
        actions.clickAndHold().perform();

    }

    private void clickOnVideoGames()
    {
        clickOnVideoGames.click();
    }
    private void clickOnFreeShipping()
    {
       wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("free_shipping")));
       freeShipping.click();
    }
    private void scroolAndSelectEurope()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("sidenav-filter-group")));
        js.executeScript("arguments[0].scrollIntoView();", europe);
        europe.click();
      //  js.executeScript("arguments[0].click();", clickOnWallClocks);
    }
    private void scroolThePageToTheEndOfFilter()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("sidenav-filter-group")));
        js.executeScript("arguments[0].click();", shipTo);
    }
    private void clickOnShipTo()
    {
        wdWait.until(ExpectedConditions.visibilityOf(shipTo));
        shipTo.click();
    }
    private void chooseRusia()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("sidenav-filter-group")));
        Select russia = new Select(driver.findElement(By.id("ship_to_select")));
        russia.selectByVisibleText("Russia");
    }
    public void toysAndEntertaiment()
    {
       clickAndHoldToysAndEntertainment();
       clickOnVideoGames();
       clickOnFreeShipping();
       scroolAndSelectEurope();
       scroolThePageToTheEndOfFilter();
       clickOnShipTo();
       chooseRusia();
    }
}
