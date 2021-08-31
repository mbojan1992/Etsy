package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.ManagingFavoriteItemsPage;
import pages.SearchWalletPage;

public class ManagingFavoriteItemsTest extends BaseTest
{
    @Test
    public void etsyManagingFavoriteItems()
    {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("bojanaqa@gmail.com", "secretpassword123.");

        SearchWalletPage swp = new SearchWalletPage(driver);
        swp.searchWallet("leather wallet for men");

        ManagingFavoriteItemsPage mcp = new ManagingFavoriteItemsPage(driver);
        mcp.managingFavoriteItems("Our new list");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div/div[3]")));
        WebElement newListFolder = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/div/div/fieldset/div/div/a[3]/span/div/p[1]"));
        Assert.assertTrue(newListFolder.getText().contains("Our new list"));
        System.out.println("");
        System.out.println("Name of folder is? " + newListFolder.getText());
    }
}
