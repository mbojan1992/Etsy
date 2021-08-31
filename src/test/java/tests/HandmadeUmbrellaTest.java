package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HandmadeUmbrellaPage;
import pages.LoginPage;

import java.util.ArrayList;

public class HandmadeUmbrellaTest extends BaseTest
{
    @Test
    public void etsyHandmadeUmbrella()
    {
        LoginPage lgp = new LoginPage(driver);
        lgp.login("bojanaqa@gmail.com", "secretpassword123.");

        HandmadeUmbrellaPage hup = new HandmadeUmbrellaPage(driver);
        hup.handmadeUmbrella("handmade umbrella");

        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("wt-mb-xs-2")));
        WebElement addToCard = driver.findElement(By.className("wt-width-full"));
        addToCard.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[1]/h1")));
        WebElement title = driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div/div[1]/h1"));
        Assert.assertTrue(title.getText().contains("1 item in your cart"));
        System.out.println(title.getText());

        driver.close();
        driver.switchTo().window(tabs1.get(0));
    }
}
