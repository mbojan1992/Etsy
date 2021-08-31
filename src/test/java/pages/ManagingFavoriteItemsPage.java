package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManagingFavoriteItemsPage extends BaseHelper
{
    // Test Case 10
    // Managing our favorite items ("hearted" items).

    @FindBy(xpath = "/html/body/div[3]/header/div[4]/nav/ul/li[1]/span/a/span")
    WebElement favorites;
    @FindBy(xpath = "/html/body/div[5]/div/div[3]/div[1]/div[1]/div[2]/div[2]/div/div/ul/li/div/button/div/span[2]/svg/path")
    WebElement heart;
    @FindBy(xpath = "/html/body/div[8]/div[9]/div/div/div[1]/fieldset/div/span[2]/label")
    WebElement remove;
    @FindBy(xpath = "wt-btn--primary")
    WebElement done;
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div/div/fieldset/div/div/span[3]/label/div[1]")
    WebElement savedSearches;
    @FindBy(xpath = "/html/body/div[5]/div/div[3]/div[1]/div[4]/ul/div/a/div/div[2]/span[1]/svg/path")
    WebElement unselectHeart;
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div/div/fieldset/div/div/div[1]/div/div/label/button")
    WebElement createNL;
    @FindBy(id = "create-list-title")
    WebElement listNameField;
    @FindBy(className = "wt-overlay__footer__action")
    WebElement createList;

    WebDriver driver;

    public ManagingFavoriteItemsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void clickOnFavoritesIcon()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("welcome-message-text")));
        favorites.click();
    }
    private void clickOnHeartForFavoriteItem()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-text-heading-01"), "Bojan"));
        heart.click();
    }
    private void clickOnRemove()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-text-center-xs"), "Add to a list"));
        remove.click();
    }
    private void clickOnDoneButton()
    {
        done.click();
    }
    private void clickOnSavedSearches()
    {
        savedSearches.click();
    }
    private void unselectHeartForSavedSearches()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-text-heading-01"), "Bojan"));
        unselectHeart.click();
    }
    private void createNewList()
    {
        createNL.click();
    }
    private void clickOnListNameField()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("wt-text-center-xs"), "Create new List"));
        listNameField.click();
    }
    private void enterOurNewListInListNameField(String term)
    {
        listNameField.sendKeys(term);
    }
    private void clickOnCreateListButton()
    {
        createList.click();
    }

    public void managingFavoriteItems(String term)
    {
        clickOnFavoritesIcon();
        clickOnHeartForFavoriteItem();
        clickOnRemove();
        clickOnDoneButton();
        clickOnSavedSearches();
        unselectHeartForSavedSearches();
        createNewList();
        clickOnListNameField();
        enterOurNewListInListNameField(term);
        clickOnCreateListButton();
    }
}
