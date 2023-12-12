package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locators
 * and create appropriate methods for it.
 */

public class HomePage extends Utility {

    //User Profile Logo
    @CacheLookup
    @FindBy(xpath = ("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
    WebElement userProfileLogo;

    //Logout Button
    @CacheLookup
    @FindBy(linkText = ("Logout"))
    WebElement logoutButton;

    //Admin Tab
    @CacheLookup
    @FindBy(xpath = ("//li[1]//a[1]//span[1]"))
    WebElement adminTab;

//=========================================================================================================//

    //Click on User Profile logo
    public void clickOnUserProfileLogo() {
        mouseHoverToElementAndClick(userProfileLogo);
    }

    //Mouse hover on "Logout" and click
    public void mouseHoverAndClickOnLogoutButton() {
        mouseHoverToElementAndClick(logoutButton);
    }

    //click On "Admin" Tab
    public void clickOnAdminTabOnLeftSideMenu() {
        clickOnElement(adminTab);
    }
}
