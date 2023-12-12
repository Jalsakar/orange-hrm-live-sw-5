package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * UserManagement, Job, Organization Tabs Locators and it's actions.
 */

public class AdminPage extends Utility {

    //System User Text
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    //Add Button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

//==========================================================================================================//

    //Verify System User Text
    public void verifySystemUsersText(String text) {
        verifyThatTextIsDisplayed(systemUsersText, text);
    }

    //Click On Add Button
    public void clickOnAddButton() {
        clickOnElement(addButton);
    }
}
