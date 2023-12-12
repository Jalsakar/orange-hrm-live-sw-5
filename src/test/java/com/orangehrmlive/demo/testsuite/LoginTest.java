package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    //Declaration
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ViewSystemUsersPage viewSystemUsersPage;
    HomePage homePage;
    AddUserPage addUserPage;
    AdminPage adminPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        //Initialisation

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        homePage= new HomePage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {

        //Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        //Verify "WelCome" Message
        loginPage.getTextForLoginPanel("WelCome");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {

        //Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        //Verify Logo is Displayed
        loginPage.getLogoElement("Logo HR for All is not displayed on the login page");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {

        //Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        //Click on User Profile logo
        homePage.clickOnUserProfileLogo();

        //Mouse hover on "Logout" and click
        homePage.mouseHoverAndClickOnLogoutButton();

        //Verify the text "Login Panel" is displayed
        loginPage.getTextForLoginPanel("Login");
    }

    @Test(groups = {"regression"}, dataProvider = "Invalid Input", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String Username, String Password, String message) {

        //Login To The application
        loginPage.logInToApplication("Admin", "admin123");

        //Verify Error message <errorMessage>
        String expected = message;
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(actual, expected, "Invalid Input");
    }
    @Test(groups = {"regression"}, dataProvider = "Invalid Input", dataProviderClass = TestData.class)
    public void verifyInvalidInputMessageWithInvalidCredentials(String Username, String Password, String message) {

        //Login To The application
        loginPage.logInToApplication(Username, Password);

        //Verify Error message <errorMessage>
        String expected = message;
        String actual = loginPage.getInvalidInputMessage();
        Assert.assertEquals(actual, expected, "Invalid Input");
    }
}
