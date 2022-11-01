package com.sentrifugo.test;


import com.sentrifugo.pages.DepartmentPage;
import com.sentrifugo.pages.LoginPage;
import com.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeparmentTest {

    @Test
    public void validateDepartmentCreated() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01","sentrifugo");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickDepartment();
        DepartmentPage departmentPage=new DepartmentPage(driver);
        Thread.sleep(3000);
        departmentPage.addDepartment("IT","Orange Blossom","Jennifer","23","Miami");
        departmentPage.validateInformation();

    }
}
