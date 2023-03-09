package Tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static Main.Login.driver;

public class Test_2 {



    @Parameters({"StartUrlLogin"})
    @Test(groups = {"regress"}, testName = "Scrolling 3")
    public void test3(String StartUrlLogin) throws InterruptedException, IOException {

        System.out.println("*** Scrolling 3 ***");

        // Переход на начальную страницу
        driver.get(StartUrlLogin);
        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.xpath("//a[@data-test-id=\"logo-footer\"]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", logo);


        try {
            // Take the screenshot and save it to a file
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File
                    ("D:\\Test\\Automation Courses\\Lesson_8\\real_life_screenshot_part.png");
            Files.move(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("*** File exists ***");
        }

        boolean isDisplayed = logo.isDisplayed();
        Assert.assertTrue(isDisplayed);
       if(logo.isEnabled()) System.out.println("ok");

    }


}


