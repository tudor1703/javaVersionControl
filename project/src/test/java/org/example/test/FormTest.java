package org.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pom.FormPom;
import org.example.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FormTest {
    public static final Logger logger = LogManager.getLogger(Basic.class);
    static public WebDriver driver;
    static public String URL ="https://demoqa.com/automation-practice-form";
    static public String FIRST_NAME = "Tudor";

    static public String LAST_NAME = "Mirca";
    static public String USER_EMAIL = "tudormirca90@gmail.com";
    static public String USER_GENDER = "Male";
    static public String USER_NUMBER = "067373552";
    static public String USER_DATE = "12 Feb 2006";
    static public String USER_SUBJECT = "English";
    static public String USER_HOBBY = "Sport";
    static public String STATE = "Rajasthan";
    static public String CITY = "Jaipur";


    @BeforeClass
    public void beforeTest() {
        logger.info("Start beforeTest");
        driver = Driver.getAutoLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest() throws InterruptedException {
        logger.info("Start formTest");
        driver.get(URL);
        FormPom form = new FormPom(driver);
        form.closeAdvert();
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(USER_EMAIL);
        form.setUserGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.setUserDateOfBirth(USER_DATE);
        form.setUserSubject(USER_SUBJECT);
        form.setUserHobbies(USER_HOBBY);
        form.setState(STATE);
        form.setCity(CITY);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        System.out.println();

        logger.info("Finish beforeTest");

        WebElement actualName = driver.findElement(By.xpath("//table//*[text()= 'Student Name']/../td[2]"));
        Assert.assertEquals(actualName.getText(),FIRST_NAME + " " + LAST_NAME);
        System.out.println();
    }


    @AfterClass
    public void afterTest() {
        driver.quit();
        logger.info("Finish afterTest");
    }
}