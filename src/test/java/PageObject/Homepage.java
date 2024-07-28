package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class Homepage
{

   WebDriver driver= BaseClass.driver;


    @FindBy(xpath = "//div[text()='Products']")
    WebElement productslable;

    @FindBy(className ="shopping_cart_badge")
    WebElement itemvalue;

   public Homepage()
   {
       PageFactory.initElements(driver,this);
   }

   public void productheader( )
   {
       Assert.assertTrue(productslable.isDisplayed());
   }
   public void additem(String itemname)
   {
      WebElement addproduct= driver.findElement(By.xpath("//div[text()='"+itemname+"']//ancestor::div[@class='inventory_item']//button"));
      addproduct.click();
   }
   public void getitemcount(int num)
   {
       Assert.assertEquals(Integer.parseInt(itemvalue.getText()),num);
   }


}
