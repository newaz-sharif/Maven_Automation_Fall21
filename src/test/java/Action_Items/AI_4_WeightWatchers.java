package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_4_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {

        //setting up chromeoptions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //start browser in incognito and maximized
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //setting up webdriver and passing options through it
        WebDriver driver = new ChromeDriver(options);

        //Create an ArrayList for zipcodes
        ArrayList<String> zipcode = new ArrayList<>();

        zipcode.add("11218");
        zipcode.add("20025");
        zipcode.add("32256");

        //for loop so we can iterate through the array for our search
        for (int i = 0; i < zipcode.size(); i++){
            //navigate to weightwatchers website
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            //click on attend to open the drowndown
            try{
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("unable to click and open dropdown " + e);
            }

            //click on unlimited workshops
            try{
                driver.findElement(By.xpath("//*[@class='MenuItem_subtitle__3LoiE']")).click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("unable to click unlimited workshops " + e);
            }

            //click on studio
            try{
                driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("unable to click studio " + e);
            }

            //enter zipcode on search bar
            try{
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipcode.get(i));
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("unable to enter zipcode " + e);
            }

            //click on the arrow to search
            try{
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("unable to click on search arrow " + e);
            }

            if (i==0){
                //for first zipcode, click on second site
                try {
                    WebElement element = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1);
                    element.click();
                    Thread.sleep(2000);
                }catch (Exception e){
                    System.out.println("unable to find location " + e);
                }//end of first search
            }else if (i==1){
                //for second zipcode, click on third site
                try {
                    WebElement element = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2);
                    element.click();
                    Thread.sleep(2000);
                }catch (Exception e){
                    System.out.println("unable to find location " + e);
                }//end of second search
            }else if (i==2){
                //for third location, click on fourth site
                try {
                    WebElement element = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(3);
                    element.click();
                    Thread.sleep(2000);
                }catch (Exception e){
                    System.out.println("unable to find location " + e);
                }//end of third search

            }//end of if/else statement

            //capture the full address of the location
            try{
                String Address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println(Address);
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to find address");
            }

            //scroll to the table of hours for virtual workshops
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //declare as webelement
            WebElement homeValueText = driver.findElement(By.xpath("//*[contains(text(),'Virtual Workshops schedule')]"));
            jse.executeScript("arguments[0].scrollIntoView(true);", homeValueText);
            Thread.sleep(2500);

            //capture the hours of operation throughout the week
            try {
                String Hours = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(Hours);
                //create a line of seperation between different locations for more user friendly view
                System.out.println();
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Unable to find hours of operation");
            }
        }//end of for loop
        //quit the driver after the loop is completed
        driver.quit();
    }//end of main method
}//end of class
