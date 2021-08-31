package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.SearchWalletPage;

public class SearchWalletTest extends BaseTest
{
    @Test
    public void etsySearchWallet()
    {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("bojanaqa@gmail.com", "secretpassword123.");

        SearchWalletPage swp = new SearchWalletPage(driver);
        swp.searchWallet("leather wallet for men");

        WebElement price = driver.findElement(By.className("currency-value"));
        Assert.assertFalse(price.getText().contains("38.50"));
        System.out.println("");
        System.out.println("The price is not good: " + price.getText());

    }
}