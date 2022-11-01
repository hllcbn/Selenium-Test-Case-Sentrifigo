package com.sentrifugo.test;

import com.sentrifugo.pages.BackGroundCheckPage;
import com.sentrifugo.pages.LoginPage;
import com.sentrifugo.pages.MainPage;

import com.utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;


public class BackGroundCheckTest {

    WebDriver driver;
    //execute the code before each test annotation.
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

    }
    @Test
    public void validateEmployeeInformation() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBackgroundCheck();
        BackGroundCheckPage backGroundCheckPage = new BackGroundCheckPage(driver);
        Thread.sleep(200);
        backGroundCheckPage.employeeInfo(driver);


    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(iTestResult.isSuccess()){
            BrowserUtil.getScreenShot(driver,"fsss");
        }
        //driver.quit();
    }
}
