package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Reusable_Actions_Loggers {
    //create a reusable method for WebDriver and chromeoptions
    public static WebDriver setDriver(){
        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //options.addArguments("fullscreen"); //for mac users
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        //options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);
        return  driver;
    }//end of webdriver method

    //method to hover on any web element
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Hovering on element " + elementName);
        logger.log(LogStatus.INFO,"Hovering on element " + elementName);
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
        }
    }//end of hover method


    //creating void click method for any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
        }
    }//end of click method

    //creating void click by index method for any web element
    public static void clickByIndex(WebDriver driver, String xpath, int index, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try {
            List<WebElement> links = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            links.get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
        }
    }//end of click method


    //creating void select by visible text method for any web element
    public static void selectByVisibleText(WebDriver driver, String xpath, String value, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Selecting element " + elementName);
        logger.log(LogStatus.INFO,"Selecting element " + elementName);
        try {
            //define the object for the dropdown element
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //define object for selection and pass it to the dropdown object
            Select valueSelect = new Select(element);
            //use selectByVisibleText method on to the selection object and pass the value
            valueSelect.selectByVisibleText(value);
        } catch (Exception e) {
            System.out.println("Unable to select " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to select " + elementName + " Error:" + e);
        }
    }//end of click method

    //creating void submit method for any web element
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Submitting on element " + elementName);
        logger.log(LogStatus.INFO,"Submitting on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName + " Error:" + e);
        }
    }//end of submit method


    //creating void sendkeys method for any web element
    public static void sendKeysMethod(WebDriver driver, String xpath, String userData, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Typing on element " + elementName);
        logger.log(LogStatus.INFO,"Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //clear first
            element.clear();
            //enter user data
            element.sendKeys(userData);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to type on " + elementName + " Error:" + e);
        }
    }//end of click sendKeysMethod

    //creating return getText method for any text web element
    public static String getTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on element " + elementName);
        //declare a global variable to capture the text so I can return it
        String result = null;
        logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //capture text
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on " + elementName + " Error:" + e);
        }
        return result;
    }//end of click getTextMethod

    //creating void scroll by pixel method
    public static void ScrollingByPixel(WebDriver driver, int horizontal_scroll, int vertical_scroll){
        System.out.println("Scrolling");
        //set your javascript command for scrolling
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to the desired part of the page
        jse.executeScript("scroll(arguments[0],arguments[1]);",horizontal_scroll,vertical_scroll);
    }//end of scroll by pixel method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static String getDateTime() {
        SimpleDateFormat sdfDateTime;
        String strDateTime;
        sdfDateTime = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
        Date now = new Date();
        strDateTime = sdfDateTime.format(now);
        return strDateTime;
    }


}//end of class
