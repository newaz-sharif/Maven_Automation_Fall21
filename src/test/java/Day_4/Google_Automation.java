package Day_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Automation {
    public static void main(String[] args) {

        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define the webdriver you are using
        WebDriver driver = new ChromeDriver();

        //navigate to the website
        driver.navigate().to("https://www.google.com");

        //maximize your browser
        driver.manage().window().maximize();

        //close your driver
        //driver.close();

    }//end of main method
}//end of class
