package TestCases;

import PageObject.Homepage;
import PageObject.LoginPage;
import org.testng.annotations.Test;

public class HomeTest extends BaseClass
{
@Test()

public void addCart()
{
    LoginPage lp=new LoginPage();
    Homepage hp=new Homepage();
    lp.LoginFunction("standard_user","secret_sauce");
    hp.productheader();
    lp.validatText("Products");
    hp.additem("Sauce Labs Backpack");
    hp.getitemcount(1);

}
}
