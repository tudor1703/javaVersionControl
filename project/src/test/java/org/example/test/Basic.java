package org.example.test;

import org.example.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

import static org.example.test.FormTest.logger;

public class Basic {
    public static final Logger logger = Logger.getLogger(Basic.class.getName());
    static WebDriver driver;

    @BeforeClass
    public void beforeTest(){
        logger.info("Start beforeTest");
        driver = Driver.getLocalDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterTest(){

        driver.quit();
        logger.info("Finish afterTest");

    }
}