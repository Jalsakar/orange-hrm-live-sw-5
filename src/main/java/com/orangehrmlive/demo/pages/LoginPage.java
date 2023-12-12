package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Store username, password, Login Button and LOGIN Panel text Locators
 * and create appropriate methods for it.
 */

public class LoginPage extends Utility {

    //Enter UserName
    @CacheLookup
    @FindBy(name = "username")
    WebElement enterUserName;

    //Enter Password
    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    //Click Login
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement clickLogin;

    //Logo Element
    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='orangehrm-logo'])[2]"))
    WebElement logoElement;
    // By logoElement = By.xpath("//div[@id='divLogo']//img");

    //Login panel#
    @CacheLookup
    @FindBy(xpath = ("(//button[normalize-space()='Login'])[1]"))
    WebElement loginPanel;

    //Error Message
    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
    WebElement errorMessage;

    //Invalid Input
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidInput;

//========================================================================================================//

    //Get Logo Element
    public void getLogoElement(String text) {
        verifyThatTextIsDisplayed(logoElement, text);
    }

    // Get Text for Login Panel
    public void getTextForLoginPanel(String text) {
        verifyThatTextIsDisplayed(loginPanel, text);
    }

    //Get Error Massage
    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }

    //Get Invalid Input Message
    public String getInvalidInputMessage() {
        return getTextFromElement(invalidInput);
    }

    //Login to Application method
    public void logInToApplication(String userName, String password) {
        sendTextToElement(enterUserName, userName);
        sendTextToElement(enterPassword, password);
        clickOnElement(clickLogin);
    }
}
