package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ToysAndEntertainmentPage;

public class ToysAndEntertaimentTest extends BaseTest
{
    @Test
    public void etsyToysAndEntertaiment()
    {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("bojanaqa@gmail.com", "secretpassword123.");

        ToysAndEntertainmentPage taep = new ToysAndEntertainmentPage(driver);
        taep.toysAndEntertaiment();

        WebElement fs1 = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div[5]/div[1]/div/div/form/div[2]/fieldset/div/div/div[1]/div/a/label"));
        fs1.getText().contains("FREE Shipping");
        System.out.println("");
        System.out.println(fs1.getText());

        WebElement fs2 = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div[5]/div[2]/div[2]/div[3]/ul/li[3]/ul/li"));
        fs2.getText().contains("FREE Shipping");
        System.out.println("");
        System.out.println(fs2.getText());

        Assert.assertSame(fs1, fs2);

    }
}


