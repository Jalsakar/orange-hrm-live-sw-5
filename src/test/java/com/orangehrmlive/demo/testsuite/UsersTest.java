package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

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
        homePage = new HomePage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void adminShouldAddUserSuccessFully() {

        //Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //click On "Add" button
        adminPage.clickOnAddButton();

        //Verify "Add User" Text
        addUserPage.getTextAddUser("Add User");

        //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");
        addUserPage.clickOnEmployeeNameOption();

        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeNameToTheField("Ananya Dash");

        //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");

        //enter Username
        addUserPage.selectUsernameInToTheUsernameField("Ananya.Dash");

        //enter password
        addUserPage.enterPasswordInToThePasswordField("admin123");

        //enter Confirm Password
        addUserPage.enterConfirmPasswordInToTheConfirmPasswordField("admin123");

        //click On "Save" Button
        addUserPage.clickOnSaveButton();

        //verify message "Successfully Saved"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");
    }

    @Test(groups = {"sanity", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {

        //Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //Enter UserName
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        //Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        //Enter Employee Name
        //Select Status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        //Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Linda.Anderson");
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

        //Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //Enter Username
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        //Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        //Select Status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        //Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Linda.Anderson");

        //Click on Check box
        viewSystemUsersPage.clickOnCheckBoxRadioButton();

        //Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();

        //Popup will display
        viewSystemUsersPage.verifyThePopUpWindowIsDisplayed();

        //Click on Ok Button on Popup
        viewSystemUsersPage.clickOnYesButton();

        //verify message "Successfully Deleted"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");
    }

    @Test(groups = {"regression"}, dataProvider = "Data Set", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound() {

        //Login to Application
        loginPage.logInToApplication("Admin", "admin123");

        //click On "Admin" Tab
        homePage.clickOnAdminTabOnLeftSideMenu();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //Enter Username <username>
        viewSystemUsersPage.searchWithUsername("Linda.Anderson");

        //Select User Role <userRole>
        addUserPage.clickOnDropDownList();
        addUserPage.selectUsernameInToTheUsernameField("Admin");

        //Enter EmployeeName <employeeName>
        viewSystemUsersPage.enterEmployeeName("Ananya Dash");

        //Select Status <status>
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        //verify message "(1) Record Found"
        viewSystemUsersPage.verifyNoRecordFoundMessage("No Records Found");

        //Verify username <username>
        viewSystemUsersPage.verifyUsernameLabel("Username");

        //Click on Reset Tab
        viewSystemUsersPage.clickOnReSetButton();
    }
}
