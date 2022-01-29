package Day_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mortgage_calc_select_command {
    public static void main(String[] args) throws InterruptedException {
        //webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //start maximized
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");
        //set the driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calc
        driver.navigate().to("https://www.mortgagecalculator.org");
        //driver.manage().window().fullscreen();
        Thread.sleep(2500);

        //scroll to the window of loan view
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to the view by pixels
        jse.executeScript("scroll(0,450)");

        //clear and type your new home value
        WebElement homeVal = driver.findElement(By.xpath("//*[contains(@name,'homevalue')]"));
        homeVal.clear(); //clear any pre set values on the home value field
        homeVal.sendKeys("350000"); //enter my new data on the home value field

        //select my new start month let say novemeber
        WebElement startMonth = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
        //select command can only be used when the drop down element is under 'Select' tag
        Select sMonthDropDown = new Select(startMonth);
        //select by visible text
        sMonthDropDown.selectByVisibleText("Nov");

        //if the dropdown tag is not under select then I need to click on the drop down and click on the value
        //startMonth.click();
        //click on the value
        //driver.findElement(By.xpath("//*[text()='Nov']")).click();


    }//end of main method
}
