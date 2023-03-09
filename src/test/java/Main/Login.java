package Main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static java.time.Duration.ofSeconds;

public class Login {

    // Инициализируем Webdriver при помощи метода public Static, для автоматического использования в других классах
    public static WebDriver driver;

    @BeforeMethod(groups = "smoke")
    @Parameters({"preferredBrowser"})
    public void setUp(String preferredBrowser) {

        if (preferredBrowser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        } else if (preferredBrowser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        }
    }

    @Parameters({"StartUrlLogin"})
    @Test(testName = "Login test", groups = {"smoke"})
    public  void case_1(String StartUrlLogin) throws IOException, InterruptedException, UnsupportedFlavorException {
        System.out.println("*** Login ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);

        Thread.sleep(2500);
        // Развертывание страницы на весь экран
        driver.manage().window().maximize();

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException m) {
            System.out.println("<<<<< No alert >>>>>");
        }
    }
}

