package com.sentrifugo.pages;

import com.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    //driver.findElement(By.xpath(//div//))
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id="loginsubmit")
    WebElement loginButton;

    @FindBy(id = "usernameerror")
    WebElement usernameError;

    @FindBy(id = "pwderror")
    WebElement passwordError;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }

    public String usernameErrorMessage(){
        return BrowserUtil.getText(usernameError);

    }

    public String passwordErrorMessage(){
        return BrowserUtil.getText(passwordError);
    }

    public String usernameErrorColor(){
        return usernameError.getCssValue("color");

    }

    public String passwordErrorColor(){
        return passwordError.getCssValue("color");

    }

}

