package Day_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_ChromOptions {
    public static void main(String[] args) throws InterruptedException {
        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //Maximize browser
        options.addArguments("start-maximized");
        //set as incognito
        options.addArguments("incognito");
        //set as headless(running the driver in the background)
        options.addArguments("headless");
        //define the webdriver you are using
        WebDriver driver = new ChromeDriver(options);

        //navigate to google
        driver.navigate().to("https://www.google.com");
        System.out.println("Navigated to Google.com");

        //searching for cars on google search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        System.out.println("entering the word 'cars' in the search field");

        //hit submit on google search button
        driver.findElement(By.xpath("//*[@value='Google Search']")).submit();
        Thread.sleep(2000);
        System.out.println("entering search word");


    }//end of main method
}//end of class
