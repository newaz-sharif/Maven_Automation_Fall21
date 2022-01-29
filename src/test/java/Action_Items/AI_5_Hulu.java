package Action_Items;

import Day_9.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AI_5_Hulu {
    //declare the webdriver outsite of the annotation method so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test(priority = 1)
    public void Hulu_create_account() throws InterruptedException {
        ArrayList<String> email = new ArrayList<>();
        email.add("laflame11223344@gmail.com");
        email.add("jcole11223344@gmail.com");
        email.add("tekoff11223344@gmail.com");

        ArrayList<String> password = new ArrayList<>();
        password.add("12345678");
        password.add("abcdefghijk");
        password.add("qwertyuiop1234567890");

        ArrayList<String> name = new ArrayList<>();
        name.add("Travis Scott");
        name.add("Jermaine Cole");
        name.add("Kershnik Ball");

        ArrayList<String> BirthMonth = new ArrayList<>();
        BirthMonth.add("January");
        BirthMonth.add("April");
        BirthMonth.add("August");

        ArrayList<String> BirthDay = new ArrayList<>();
        BirthDay.add("8");
        BirthDay.add("11");
        BirthDay.add("23");

        ArrayList<String> BirthYear = new ArrayList<>();
        BirthYear.add("1990");
        BirthYear.add("1997");
        BirthYear.add("2000");

        ArrayList<String> Gender = new ArrayList<>();
        Gender.add("Male");
        Gender.add("Female");
        Gender.add("Prefer not to say");


        for (int i = 0; i < email.size(); i++){
            //navigate to Hulu website
            driver.navigate().to("https://www.hulu.com");
            //verify that the title contains "Stream TV and Movies"
            String ActualTitle = driver.getTitle();
            if(ActualTitle.equals("Steam TV and Movies")){
                System.out.println("Title matches as " + ActualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + ActualTitle);
            }
            //scroll down to plan options
            Reusable_Actions.ScrollingByPixel(driver,0,3000);
            //click on "select" under the most popular 30 day free trial
            Reusable_Actions.clickMethod(driver,"//*[text()='SELECT']","Select");
            //Enter email
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='email']",email.get(i),"email");
            //Enter password
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='password']",password.get(i),"password");
            //Enter name
            Reusable_Actions.sendKeysMethod(driver,"//*[@id='firstName']",name.get(i),"name");
            //Enter Birth month
            Reusable_Actions.clickMethod(driver,"//*[text()='Month']","Birth Month");
            Reusable_Actions.clickMethod(driver,"//*[text()='" + BirthMonth.get(i) + "']","Birth Month");
            //Enter Birth day
            Reusable_Actions.clickMethod(driver,"//*[text()='Day']","Day");
            Reusable_Actions.clickMethod(driver,"//*[text()='" + BirthDay.get(i) + "']","Birth Day");
            //Enter Birth year
            Reusable_Actions.clickMethod(driver,"//*[text()='Year']","Year");
            Reusable_Actions.clickMethod(driver,"//*[text()='" + BirthYear.get(i) + "']","Birth Year");
            //Enter gender
            Reusable_Actions.clickMethod(driver,"//*[@data-testid='gender']","Gender");
            Reusable_Actions.clickMethod(driver,"//*[text()='" + Gender.get(i) + "']","Gender");
            //click on continue
            Reusable_Actions.clickMethod(driver,"//*[@class='button button--continue ']","Continue");
            //wait a few seconds
            Thread.sleep(3000);
            //capture and print the subscription amount
            String subscription_amount = Reusable_Actions.getTextMethod(driver,"//*[@class='ledger__price']","subscription amount");
            System.out.println("Your monthly subcription amount is " + subscription_amount);
            //capture and print total due today
            String total_due = Reusable_Actions.getTextMethod(driver,"//*[@class='summary__price']","Total due");
            System.out.println("Your total due today is " + total_due);

            //delete all cookies
            driver.manage().deleteAllCookies();
        }//end of for loop

    }//end of test 1

    @Test(dependsOnMethods = {"Hulu_create_account"})
    public void hulu_login(){
        //navigate to Hulu website
        driver.navigate().to("https://www.hulu.com");
        //click on login
        Reusable_Actions.clickMethod(driver,"//*[text()='Log In']","log in");
        //enter username
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='email_id']","johncena535647875@gmail.com","username");
        //enter password
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='password_id']","12345678","password");
        //click on login after entering in information
        Reusable_Actions.clickMethod(driver,"//*[text()='LOG IN']","log in button");
        //verify that you are logged in by getting the name after signing in
        String userName = Reusable_Actions.getTextMethod(driver,"//*[@href='/account']","Name");
        System.out.println("You are logged in as " + userName);

    }//end of test 2

    @AfterSuite
    public void CloseDriver(){
        driver.quit();
    }
}//end of class
