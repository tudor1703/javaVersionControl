package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.utils.fluentWait;


public class LoginPom extends BasicPom {

    @FindBy(xpath = "//*[@id='userName']")
    WebElement userName;
    @FindBy(xpath = "//*[@id='password']")
    WebElement password;
    @FindBy(xpath = "//*[@id='login']")
    WebElement submit;
    @FindBy(xpath = "//*[@id='userName-value']")
    WebElement userNameTitle;

    public LoginPom (WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public String clickLogin() {
        submit.click();
        fluentWait(driver, By.xpath("//*[@id='userName-value']"), 10);
        return userNameTitle.getText();
    }
    public void setUserName (String userNameParam) {
        scrollToElement(userName);
        userName.clear();
        userName.sendKeys (userNameParam);
    }

    public void setPassword(String passParam) {
        password.clear();
        password.sendKeys(passParam);
    }
}