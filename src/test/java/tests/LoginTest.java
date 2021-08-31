package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;

public class LoginTest extends BaseTest
{
    @Test
    public void etsyLogin() {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("bojanaqa@gmail.com", "secretpassword123.");


        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/section/div[1]/div[1]/div/div/div/h1[1]")));
        WebElement validAssert = driver.findElement(By.xpath("/html/body/div[5]/div/section/div[1]/div[1]/div/div/div/h1[1]"));
        Assert.assertTrue(validAssert.getText().contains("Welcome back, Bojan"));
        System.out.println("After successful login you can see: " + validAssert.getText());
    }
}
