package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * User Role Drop Down, Employee Name, Username, Status Drop Down,
 * Password, Confirm Password, Save and Cancel Button Locators and it's actions
 */

public class AddUserPage extends Utility {

    //Add User Text
    @CacheLookup
    @FindBy(xpath = ("//h6[normalize-space()='Add User']"))
    WebElement addUserText;

    //Select Drop Down
    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
    WebElement selectDropDown;

    //User Role
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Admin')])[1]")
    WebElement userRole;

    //Employee Name
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

    //Employee Drop down
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeDropDown;

    //Enter UserName
    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement enterUsername;

    //Disable Status
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disabledStatus;

    //Password Field
    @CacheLookup
    @FindBy(xpath = ("(//input[@type='password'])[1]"))
    WebElement passwordField;
    //By passwordField = By.xpath("//input[@type = 'password']");

    //Confirm Password Field
    @CacheLookup
    @FindBy(xpath = ("(//input[@type='password'])[2]"))
    WebElement confirmPasswordField;

    //Save Button
    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Save']"))
    WebElement saveButton;

    //Successfully Save Message
    @CacheLookup
    @FindBy(xpath = ("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"))
    WebElement successfullySaveMessage;

//=============================================================================================================//

    //Get Text Add User
    public void getTextAddUser(String text) {
        verifyThatTextIsDisplayed(addUserText, text);
    }

    //Click on Down Drop List
    public void clickOnDropDownList() {
        clickOnElement(selectDropDown);
    }

    //Select User Role from Drop Down
    public void selectUserRoleFromDropDownList(String option) {
        dynamicListDropDown(userRole, option);
        CustomListeners.test.log(Status.SKIP, "There is a bug");
    }

    //Click on EmployeeName option
    public void clickOnEmployeeNameOption() {
        mouseHoverToElementAndClick(employeeDropDown);
    }

    //Enter Employee Name To the Field
    public void enterEmployeeNameToTheField(String name) {
        sendTextToElement(employeeName, name);
        CustomListeners.test.log(Status.SKIP, "There is a bug");
    }

    //Select UserName into the UserName Field
    public void selectUsernameInToTheUsernameField(String username) {
        sendTextToElement(enterUsername, username);
        CustomListeners.test.log(Status.SKIP, "There is a bug");
    }

    //Select Status from Drop Down List
    public void selectStatusFromDropDownList(String option) {
        dynamicListDropDown(disabledStatus, option);
    }

    //Enter Password to the password Field
    public void enterPasswordInToThePasswordField(String password) {
        sendTextToElement(passwordField, password);
    }

    //Enter Confirm Password into the Confirm Password Field
    public void enterConfirmPasswordInToTheConfirmPasswordField(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    //Click on Save Button
    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    //Get text for Successfully Message after Saved Added User
    public void getTextForSuccessfullyMessageAfterSavedAddedUser(String text) {
        verifyThatTextIsDisplayed(successfullySaveMessage, text);
    }
}
