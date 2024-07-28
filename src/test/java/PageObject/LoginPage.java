package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage
{
    WebDriver driver= BaseClass.driver;

    @FindBy(id = "user-name")
    WebElement  userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "product_label")
    WebElement pageHeader;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errormessage;

    public  LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void LoginFunction(String username, String password)
    {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void validatText(String str1)
    {
        String actmsg=pageHeader.getText();
        Assert.assertEquals(actmsg,str1);
    }
    public void validaterrorText(String str2)
    {
        String actmsg=errormessage.getText();
        Assert.assertEquals(actmsg,str2);
    }
}
