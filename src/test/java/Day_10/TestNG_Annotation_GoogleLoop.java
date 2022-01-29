package Day_10;

import Day_9.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Annotation_GoogleLoop {
    //declare the webdriver outsite of the annotation method so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test
    public void GoogleSearchLoop(){
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedez");
        cars.add("Tesla");

        for (int i = 0; i < cars.size(); i++){
            //navigate to google page
            driver.navigate().to("https://www.google.com");
            Reusable_Actions.sendKeysMethod(driver,"//*[@name='q']", cars.get(i),"search field");
        }//end of for loop
    }//end of test

    @AfterSuite
    public void endSession(){
        driver.quit();
    }

}//end of class
