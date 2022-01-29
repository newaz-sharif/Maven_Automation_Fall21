package Day_5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Array_Test {
    public static void main(String[] args) throws InterruptedException {
        //search multiple cities and each time capture the search number from the results page

        //set an array
        String[] cities = new String[4];

        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Bronx";
        cities[3] = "Manhattan";

        //define the webdriver outside of the for loop so it doesn't keep opening new windows
        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i < cities.length; i++){
            //simply open the google website
            driver.navigate().to("https://www.google.com");

            //maximize my browser
            driver.manage().window().maximize(); //for windows

            //anytime when you go to a new page you should put some wait statement
            Thread.sleep(2000);

            //searching for cars on google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            //hit submit on google search button
            driver.findElement(By.xpath("//*[@value='Google Search']")).submit();
            Thread.sleep(2000);

            //capture the result and store it as a value
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //declare the array variable to split the result using single space
            String[] arrayResult = result.split(" ");
            //now print the search number only
            System.out.println("My search number for the city " + cities[i] + " is " + arrayResult[1]);


        }//end of for loop

        //quit the driver outside of the for loop so it only quits once its finished
        driver.quit();

    }//end of main method
}//end of class
