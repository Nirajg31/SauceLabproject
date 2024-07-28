package TestCases;

import PageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass
{
    @Test
    public void TC01_LoginSuccess()
    {
        LoginPage lP=new LoginPage();

        lP.LoginFunction("standard_user","secret_sauce");
        lP.validatText("Products");

    }
    @Test
    public void TC02_LoginFailure()
    {
        LoginPage lP=new LoginPage();
        lP.LoginFunction("standard_user","Test@123");
        lP.validaterrorText("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void TC03_LockedUser()
    {
        LoginPage lP=new LoginPage();
        lP.LoginFunction("locked_out_user","secret_sauce");
        lP.validaterrorText("Epic sadface: Sorry, this user has been locked out.");

    }
}
