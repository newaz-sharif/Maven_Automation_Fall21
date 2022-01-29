package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AI_3_Bing {
    public static void main(String[] args) throws InterruptedException {
        //set an array for hobbies
        String[] hobby = new String[6];

        //list of hobbies
        hobby[0] = "soccer";
        hobby[1] = "football";
        hobby[2] = "gym";
        hobby[3] = "painting";
        hobby[4] = "track";
        hobby[5] = "guitar";

        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //Maximize browser
        options.addArguments("start-maximized");
        //set as incognito
        options.addArguments("incognito");
        //define the webdriver you are using
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < hobby.length; i++){
            //navigate to bing
            driver.navigate().to("https://www.bing.com");
            System.out.println("Navigated to bing.com");
            //wait a few seconds
            Thread.sleep(2000);
            //entering a keyword on search field
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(hobby[i]);
            System.out.println("entering the word " + hobby[i] + " in the search field");
            //clicking on search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).click();
            System.out.println("clicking on search button");
            //wait a few seconds
            Thread.sleep(2000);

            //capture the result and store it as a value
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //declare the array variable to split the result using single space
            String[] arrayResult = result.split(" ");
            //print the search number only
            System.out.println("My search number for the hobby " + hobby[i] + " is " + arrayResult[0]);

        }//end of for loop

        //quit the driver outside the loop
        driver.quit();
    }//end of main method
}//end of class
