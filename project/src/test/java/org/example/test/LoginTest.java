package org.example.test;

import org.example.pom.LoginPom;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends Basic{

    static public String URL = "https://demoqa.com/login";
    static public String USER_NAME = "artur";
    static public String PASSWORD = "GuFWp4J79G2D9!b";
    @Test

    public void loginTest() {
        logger.info("Start formTest");
        driver.get(URL);
        LoginPom loginPom = new LoginPom(driver);
        loginPom.setUserName (USER_NAME);
        loginPom.setPassword (PASSWORD);
        String title = loginPom.clickLogin();
        Assert.assertEquals(title, USER_NAME);
        logger.info("Finish formTest");
    }
}