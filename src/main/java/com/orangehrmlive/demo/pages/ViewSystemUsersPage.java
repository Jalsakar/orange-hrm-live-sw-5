package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * System Users Text, Username Field, User Roll dropDown,
 * Employee Name Field, Status Drop Down, Search Button, Reset Button,
 * Add Button and Delete Button locators and it's actions.
 */

public class ViewSystemUsersPage extends Utility {

    //Search with UserName
    @CacheLookup
    @FindBy(xpath = ("(//input[@class='oxd-input oxd-input--active'])[2]"))
    WebElement searchWithUsername;

    //EmployeeName
    @CacheLookup
    @FindBy(xpath = ("//input[@placeholder='Type for hints...']"))
    WebElement employeeName;

    //Search with Status
    @CacheLookup
    @FindBy(xpath = ("(//i)[13]"))
    WebElement searchWithStatus;

    //Search Button
    @CacheLookup
    @FindBy(xpath = ("(//button[normalize-space()='Search'])[1]"))
    WebElement searchButton;

    //Search Result
    @CacheLookup
    @FindBy(xpath = ("//div[contains(text(),'khilenpatel123')]"))
    WebElement searchResult;

    //Check Box
    @CacheLookup
    @FindBy(xpath = ("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])"))
    WebElement checkBox;

    //Delete Button
    @CacheLookup
    @FindBy(xpath = ("(//i[@class='oxd-icon bi-trash'])"))
    WebElement deleteButton;

    //Popup window
    @CacheLookup
    @FindBy(xpath = ("(//div[@role='document'])[1]"))
    WebElement popUpWindow;

    //Yes Button
    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Yes, Delete']"))
    WebElement yesButton;

    //Reset Button
    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Reset']"))
    WebElement reSetButton;

    //Verify UserName
    @CacheLookup
    @FindBy(xpath = ("//label[normalize-space()='Username']"))
    WebElement verifyUsername;

    //No Record Found
    @CacheLookup
    @FindBy(xpath = ("//span[normalize-space()='No Records Found']"))
    WebElement noRecordFound;

//==========================================================================================================//

    //Search with Username
    public void searchWithUsername(String name) {
        sendTextToElement(searchWithUsername, name);
    }

    //Enter EmployeeName
    public void enterEmployeeName(String name) {
        sendTextToElement(employeeName, name);
    }

    //Click On Search with Status Drop Down
    public void clickOnSearchWithStatusDropDown() {
        clickOnElement(searchWithStatus);
    }

    //Click on Search Button
    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    //Verify the Search Result List
    public void verifyTheSearchResultList(String text) {
        verifyThatTextIsDisplayed(searchResult, text);
    }

    //Click on Check Box Radio Button
    public void clickOnCheckBoxRadioButton() {
        clickOnElement(checkBox);
    }

    //Click on Delete Button
    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }

    //Verify the PopUp Window is displayed
    public void verifyThePopUpWindowIsDisplayed() {
        verifyThatElementIsDisplayed(popUpWindow);
    }

    //Click on Yes Button
    public void clickOnYesButton() {
        clickOnElement(yesButton);
    }

    //Verify no record found message
    public void verifyNoRecordFoundMessage(String text) {
        verifyThatTextIsDisplayed(noRecordFound, text);
    }

    //Verify UserName Label
    public void verifyUsernameLabel(String text) {
        verifyThatTextIsDisplayed(verifyUsername, text);
    }

    //Click on Reset Button
    public void clickOnReSetButton() {
        clickOnElement(reSetButton);
    }
}