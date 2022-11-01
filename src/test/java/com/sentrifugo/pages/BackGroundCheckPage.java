package com.sentrifugo.pages;

import com.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;

public class BackGroundCheckPage {

    public BackGroundCheckPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@title='Adds']")
    WebElement addButton;

    @FindBy(xpath = "//div[contains(text(), 'You cannot send an employee for background check as the screening configurations are not set yet " )
    WebElement message;

    @FindBy(id = "sid_employee")
    WebElement selectEmployee;

    @FindBy(xpath = "//span[.='Emily Emma, Trainee']")
    WebElement employee;

    @FindBy(xpath= "//div[@id='personalDetailsDiv']//span")
    List<WebElement> allInformation;

    @FindBy(id = "checktype-2")
    WebElement creditCheckBox;


    @FindBy(xpath = "//divl.='No agency']")
    WebElement agencyMessage;

    @FindBy(id="submitbutton")
    WebElement saveButton;
    public void employeeInfo(WebDriver driver) throws InterruptedException {
        addButton.click();//clicks the button
        Assert.assertEquals(BrowserUtil.getText(message),"You cannot send an employee for background check as the screening configurations are not set yet.");
        selectEmployee.click();//for the box
        employee.click(); // for the employee
        List<String> expectedInformation= Arrays.asList("Emily Emma","emily@example.com","Active");
        for(int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtil.getText(allInformation.get(i)),expectedInformation.get(i));
        }
        Thread.sleep(3000);
        creditCheckBox.click();
        Assert.assertTrue(creditCheckBox.isSelected());
        Assert.assertEquals(BrowserUtil.getText(agencyMessage),"No agency");
        BrowserUtil.scrollWithJs(driver,saveButton);
        saveButton.click();

    }

}
