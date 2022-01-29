package Day_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mortgage_calc_scroll {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver
        WebDriverManager.chromedriver().setup();
        // set up your options and set your arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //set up your driver with options
        WebDriver driver = new ChromeDriver(options);
        //navigate to the mo    rtgage calculator website
        driver.navigate().to("https://www.mortgagecalculator.org");
        //set wait time to load page
        Thread.sleep(2000);
        //scroll to the windows loan view
        //set your javascript command for scrolling
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to the desired page
        jse.executeScript("scroll(0,450)");

    }//end of main method
}//end of class
