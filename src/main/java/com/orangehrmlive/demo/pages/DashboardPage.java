package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard text Locator and create appropriate methods for it.
 */

public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = ("//h6[normalize-space()='Dashboard']"))
    //@FindBy(css = (".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"))
    WebElement dashboardMessage;

//======================================================================================================//

    //Get Text from Dashboard Message
    public void getTextFromDashboardMessage(String text) {
        verifyThatTextIsDisplayed(dashboardMessage, text);
    }

}
