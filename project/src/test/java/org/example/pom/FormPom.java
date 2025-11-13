package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.utils.fluentWait;

public class FormPom {

    public static WebDriver driver;
    public static JavascriptExecutor js;

    @FindBy(xpath ="//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath ="//*[@id='lastName']")
    WebElement lastName;

    @FindBy (xpath = "//*[@id=\"userEmail\"]")
    WebElement userEmail;

    //

    @FindBy (xpath = "//*[@id=\"userNumber\"]")
    WebElement userNumber;

    @FindBy (xpath = "//*[@id=\"dateOfBirthInput\"]")
    WebElement userDateOfBirth;

    @FindBy(id = "subjectsInput")
    WebElement userSubjectsInput;

    @FindBy (xpath = "//*[@id='checkbox']")
    WebElement userHobbies;

    @FindBy (xpath = "//div[@id='state']")
    WebElement stateDropdown;

    @FindBy (xpath = "//div[@id='city']")
    WebElement cityDropdown;




    public FormPom(WebDriver driver){
        this.driver =  driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstNameParam) {
        scrollToElement(firstName);
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }

    public void setLastName(String lastNameParam) {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }

    public void setUserEmail(String userEmailParam) {
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setUserGender(String userGenderParam) {
        WebElement element = driver.findElement(By.xpath("//*[@id='genterWrapper']//label[text()= '" + userGenderParam + "']"));
        element.click();
    }


    public void setUserNumber (String userNumberParam){
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);
    }


    public void setUserDateOfBirth(String userDateOfBirthParam) {
        userDateOfBirth.sendKeys(Keys.CONTROL + "a");
        userDateOfBirth.sendKeys(userDateOfBirthParam);
        userDateOfBirth.sendKeys(Keys.ENTER);
    }

    public void setUserSubject (String userSubjectParam) {
        userSubjectsInput.sendKeys(userSubjectParam);
        userSubjectsInput.sendKeys(Keys.ENTER);
    }

    public void setUserHobbies(String userHobbyParam) {
        WebElement hobbyLabel = driver.findElement(By.xpath(
                "//*[@id='hobbiesWrapper']//label[normalize-space(text())='" + userHobbyParam + "']"
        ));
        scrollToElement(hobbyLabel);
        try {
            hobbyLabel.click();
        } catch (Exception e) {
            try {
                String forAttr = hobbyLabel.getAttribute("for");
                WebElement input = driver.findElement(By.id(forAttr));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
            } catch (Exception ignored) {}
        }
    }


    public void setState(String stateParam) {
        stateDropdown.click();
        fluentWait(driver, By.xpath("//*[text()='"+ stateParam +"']"), 10);
        WebElement state = driver.findElement(By.xpath("//*[text()='"+ stateParam +"']"));
        state.click();
    }

    public void setCity(String cityParam) {
        cityDropdown.click();
        fluentWait(driver, By.xpath("//*[text()='"+ cityParam +"']"), 10);
        WebElement city = driver.findElement(By.xpath("//*[text()='"+ cityParam +"']"));
        city.click();
    }


    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='adplus-anchor']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {}
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
