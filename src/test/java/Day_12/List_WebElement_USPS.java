package Day_12;

import Day_9.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class List_WebElement_USPS {

    WebDriver driver;
    @BeforeSuite
    public void setDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite

    @Test
    public void uspsTest(){
        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //using explicit wait to get the count of elements within same class group
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            List<WebElement> uspsTabs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            System.out.println("My Nav list count is " + uspsTabs.size());
        } catch (Exception e) {
            System.out.println("unable to locate links " + e);
        }

    }//end of test



}//end of class
