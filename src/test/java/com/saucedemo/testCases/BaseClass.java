package com.saucedemo.testCases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public String baseURL = "https://www.saucedemo.com";
    public String username = "standard_user";
    public String password = "secret_sauce";
    public static WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL); // Load the base URL
    }

    public void takeScreenshot(String methodName) {
        // Create a screenshot directory if it doesn't exist
        Path screenshotDir = Paths.get(System.getProperty("user.dir"), "Screenshots");
        if (!Files.exists(screenshotDir)) {
            try {
                Files.createDirectories(screenshotDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Capture screenshot as a file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshot = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = methodName + "_" + screenshot + ".png";

        // Save screenshot to the screenshots directory
        Path targetPath = Paths.get(screenshotDir.toString(), screenshotName);
        try {
            Files.copy(screenshotFile.toPath(), targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
