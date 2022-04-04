package tests;

import bases.TestBase;
import org.junit.*;
import pages.LoginPage;
import pages.ReportIssuePage;
import pages.ViewIssuePage;


import static org.junit.Assert.*;

public class MantisTest extends TestBase {
    LoginPage loginPage;
    ReportIssuePage reportIssuePage;
    ViewIssuePage viewIssuePage;

    @Test
    public void loginSuccessfully(){
        loginPage = new LoginPage(driver);

        loginPage.setUsername("theron.santos");
        loginPage.setPassword("148623tH@");
        loginPage.setLogin();

        assertEquals("Logout", loginPage.getMessageLoginSucess());
    }

    @Test
    public void loginFailed(){
        String msg = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        loginPage = new LoginPage(driver);

        loginPage.setUsername("theron.santos");
        loginPage.setPassword("148623tH");
        loginPage.setLogin();

        assertEquals(msg,loginPage.getMessageLoginFailed());
    }

    @Test
    public void registerIssue(){
        loginPage = new LoginPage(driver);
        reportIssuePage = new ReportIssuePage(driver);

        loginPage.setUsername("theron.santos");
        loginPage.setPassword("148623tH@");
        loginPage.setLogin();

        reportIssuePage.setClickReportIssue();
        reportIssuePage.setProject();
        reportIssuePage.setClickBtnSelectProject();
        reportIssuePage.setCategory();
        reportIssuePage.setProfile();
        reportIssuePage.setAssignTo();
        reportIssuePage.setSummary();
        reportIssuePage.setDescription();
        reportIssuePage.setClickSubmitReport();

        assertEquals("MantisBT", reportIssuePage.getTitle());
    }

    @Test
    public void registerIssueFailed() {
        loginPage = new LoginPage(driver);
        reportIssuePage = new ReportIssuePage(driver);

        loginPage.setUsername("theron.santos");
        loginPage.setPassword("148623tH@");
        loginPage.setLogin();

        reportIssuePage.setClickReportIssue();
        reportIssuePage.setClickBtnSelectProject();
        reportIssuePage.setClickSubmitReport();

        assertEquals("APPLICATION ERROR #11", reportIssuePage.getMessageReportIssueFailed());
    }

    @Test
    public void viewIssue(){
        loginPage = new LoginPage(driver);
        viewIssuePage = new ViewIssuePage(driver);

        loginPage.setUsername("theron.santos");
        loginPage.setPassword("148623tH@");
        loginPage.setLogin();

        viewIssuePage.setClickViewIssue();
        viewIssuePage.getViewIssue();

        assertEquals("View Issue Details [ Jump to Notes ] [ Send a reminder ]", viewIssuePage.getMessageViewDetais());
    }
}
