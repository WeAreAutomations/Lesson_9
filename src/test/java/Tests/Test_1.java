package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static Main.Login.driver;

public class Test_1 {


    @Parameters({"StartUrlLogin"})
    @Test(groups = {"smoke"}, testName = "Keys")
    public void test1(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Keys ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);
        Thread.sleep(3000);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("wpt");

        searchInput.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT,Keys.ARROW_LEFT, "!");
        Thread.sleep(2000);
//        searchInput.sendKeys(Keys.HOME, "!");

        searchInput.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);

        searchInput.sendKeys(Keys.DELETE);
        Thread.sleep(2000);

        searchInput.sendKeys("wpt");
        Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(By.xpath
                ("//button[@class=\"button button_color_green button_size_medium search-form__submit ng-star-inserted\"]"));
        searchBtn.click();

        searchInput.sendKeys(Keys.ENTER);

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    }

    @Parameters({"StartUrlLogin"})
    @Test(groups = {"regress"}, testName = "Scrolling 2")
    public void test2(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Scrolling 1 ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);
        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.xpath("//a[@data-test-id=\"logo-footer\"]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", logo);

        WebElement Apple = driver.findElement(By.xpath("//a[@class=\"app-item\"][1]"));

        boolean isDisplayed = logo.isDisplayed();
        Assert.assertTrue(isDisplayed);

    }


}


