package Action_Items;

import Day_9.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class AI_6_Express {
    WebDriver driver;
    //your extentreport and extenttest command should be declared outside so it can be reusable among all annotations
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
        //set the path of the report once
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }//end of precondition

    @Test()
    public void expressCheckingOut() throws InterruptedException, BiffException, IOException, WriteException {
        //Step 1: read the data from the excel sheet you created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/ExpressCheckout.xls"));
        //Step 2: locating the worksheet that you created for the workbook
        //Sheet readableSheet = readableFile.getSheet(0);
        //will return the physical rows present on the sheet
        //int rowCount = readableSheet.getRows();
        //Step 3: create a writable file to mimic readable but you can also write back the results to this file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressCheckout_Results.xls"),readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount = writableSheet.getRows();

        //generate the for/while loop
        int i = 1;
        while( i < rowCount){
            //store the size list as a variable
            String size = writableSheet.getCell(0,i).getContents();
            //store the quantity list as a variable
            String quantity = writableSheet.getCell(1,i).getContents();
            //store the first name list as a variable
            String firstName = writableSheet.getCell(2,i).getContents();
            //store the last name list as a variable
            String lastName = writableSheet.getCell(3,i).getContents();
            //store the email list as a variable
            String email = writableSheet.getCell(4,i).getContents();
            //store the phone number list as a variable
            String phoneNumber = writableSheet.getCell(5,i).getContents();
            //store the address list as a variable
            String address = writableSheet.getCell(6,i).getContents();
            //store the zipCode list as a variable
            String zipCode = writableSheet.getCell(7,i).getContents();
            //store the city list as a variable
            String city = writableSheet.getCell(8,i).getContents();
            //store the state list as a variable
            String state = writableSheet.getCell(9,i).getContents();
            //store the card number list as a variable
            String cardNumber = writableSheet.getCell(10,i).getContents();
            //store the expiration month list as a variable
            String expMonth = writableSheet.getCell(11,i).getContents();
            //store the expiration year list as a variable
            String expYear = writableSheet.getCell(12,i).getContents();
            //store the ccv list as a variable
            String ccv = writableSheet.getCell(13,i).getContents();

            logger = reports.startTest("Track a package on USPS");
            //navigate to express
            logger.log(LogStatus.INFO,"Navigate to USPS home page");
            driver.navigate().to("https://www.express.com");
            //verify we are on the right page
            String ActualTitle = driver.getTitle();
            if(ActualTitle.equals("Men's and Women's Clothing")){
                System.out.println("Title matches as " + ActualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + ActualTitle);
            }
            //hover over "women" tab
            Reusable_Actions_Loggers.mouseHover(driver,"//*[@href='/womens-clothing?W_HEADER_WOMENSCLOTHING']",logger,"Women");
            //click on dresses
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Dresses']",logger,"Dresses");
            Thread.sleep(3000);
            //Closes popup if it appears
            Reusable_Actions_Loggers.clickMethod(driver,"//*[@name='bluecoreCloseButton']",logger,"Pop up");
            //scroll down a little
            Reusable_Actions_Loggers.ScrollingByPixel(driver,0,500);
            //click on second image using index
            Reusable_Actions_Loggers.clickByIndex(driver,"//*[@class='_2fbIe3xmE78JEQRb26pdpQ']",1,logger,"product");
            Thread.sleep(3000);

            //select the size you want
            Reusable_Actions_Loggers.clickMethod(driver, "//*[contains(@aria-label, 'Select "+size.toLowerCase(Locale.ROOT)+" Size')]", logger,"Size "+size);
            //click on add to bag
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Add to Bag']",logger,"add to bag");
            //click on view bag
            Reusable_Actions_Loggers.clickMethod(driver,"//*[@aria-label='view bag']",logger,"view bag");
            Thread.sleep(3000);
            //enter quantity
            Reusable_Actions_Loggers.selectByVisibleText(driver,"//*[@id='qdd-0-quantity']",quantity,logger,"quantity");
            //click on checkout
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Checkout']",logger,"checkout");
            Thread.sleep(3000);
            //click on checkout as guest
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Checkout as Guest']",logger,"checkout as guest");
            Thread.sleep(3000);
            //Enter first name
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='firstname']",firstName,logger,"first name");
            //Enter last name
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='lastname']",lastName,logger,"last name");
            //Enter email
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='email']",email,logger,"email");
            //confirm email
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='confirmEmail']",email,logger,"confirm email");
            //enter phone number
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='phone']",phoneNumber,logger,"phone number");
            //click on continue
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']",logger,"continue");
            //enter street address
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='shipping.line1']",address,logger,"street address");
            //enter postal code
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"zipcode");
            //enter city
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='shipping.city']",city,logger,"city");
            //enter state
            Reusable_Actions_Loggers.selectByVisibleText(driver,"//*[@name='shipping.state']",state,logger,"state");
            //click on continue to get to shipping options
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']",logger,"continue again");
            //click on continue again to get to payment option
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Continue']",logger,"continue again");
            //enter credit card number
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='creditCardNumber']",cardNumber,logger,"card number");
            //enter expiration month
            Reusable_Actions_Loggers.selectByVisibleText(driver,"//*[@name='expMonth']",expMonth,logger,"expiration month");
            //enter expiration year
            Reusable_Actions_Loggers.selectByVisibleText(driver,"//*[@name='expYear']",expYear,logger,"expiration year");
            //enter ccv number
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name='cvv']",ccv,logger,"ccv number");
            //click on place order
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Place Order']",logger,"Place Order");

            //capture the result
            String results = Reusable_Actions_Loggers.getTextMethod(driver,"//*[@class='_18MKSBxx labelError']",logger,"error message");

            //Step 5: storing the values to the writable excel sheet
            Label label = new Label(14,i,results);
            //I need to write back to the writable sheet
            writableSheet.addCell(label);

            //delete all cookies
            driver.manage().deleteAllCookies();

            //increment
            i = i+1;
        }//end of while loop

        //Step 6: writing back to the writable file to see
        writableFile.write();
        writableFile.close();





        //end the logger
        reports.endTest(logger);
    }//end of test

    @AfterSuite
    public void endTest(){
        driver.quit();
        //write/log the information back to the html report
        reports.flush();
    }//end of after suite


}//end of class
