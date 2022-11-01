package com.sentrifugo.test;

import com.sentrifugo.pages.LoginPage;

import com.utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


public class LoginTest extends LoginTestProvider{
    @Test
    public void validatePositiveLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        Assert.assertEquals(driver.getCurrentUrl(), "http://demo.sentrifugo.com/index.php/index/welcome");

    }

    public void validateLogin1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        //Assert.assertEquals(driver.getCurrentUrl(),"http://demo.sentrifugo.com/index.php/index/welcome");
        Assert.assertEquals(loginPage.usernameErrorMessage(), "Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Please enter password.");
        Assert.assertEquals(loginPage.usernameErrorColor(), "rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.passwordErrorColor(), "rgba(255, 0, 0, 1)");
    }

    @Test(dataProvider = "fullLogin", dataProviderClass = LoginTestProvider.class)
    public void validation0fLogin(String username, String password) {
        WebDriver driver = DriverHelper.getDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("welcome"));
        driver.quit();
    }
}
