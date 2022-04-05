package tests;

import bases.TestBase;
import flows.LoginFlow;
import org.junit.*;
import pages.LoginPage;
import pages.ReportIssuePage;
import pages.ViewIssuePage;


import static org.junit.Assert.*;

public class MantisTest extends TestBase {
    LoginPage loginPage;
    ReportIssuePage reportIssuePage;
    ViewIssuePage viewIssuePage;
    LoginFlow loginFlow;

    @Test
    public void loginSuccessfully(){
        loginPage = new LoginPage(driver);
        loginFlow = new LoginFlow(driver);

        loginFlow.setLoginService("usuario","senha");
        assertEquals("Logout", loginPage.getMessageLoginSucess());
    }

    @Test
    public void loginFailed(){
        loginPage = new LoginPage(driver);
        loginFlow = new LoginFlow(driver);

        loginFlow.setLoginService("usuario","senha");

        String msg = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        assertEquals(msg,loginPage.getMessageLoginFailed());
    }

    @Test
    public void registerIssue(){
        reportIssuePage = new ReportIssuePage(driver);
        loginFlow = new LoginFlow(driver);

        loginFlow.setLoginService("usuario","senha");

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
        reportIssuePage = new ReportIssuePage(driver);
        loginFlow = new LoginFlow(driver);

        loginFlow.setLoginService("usuario","senha");

        reportIssuePage.setClickReportIssue();
        reportIssuePage.setClickBtnSelectProject();
        reportIssuePage.setClickSubmitReport();

        assertEquals("APPLICATION ERROR #11", reportIssuePage.getMessageReportIssueFailed());
    }

    @Test
    public void viewIssue(){
        viewIssuePage = new ViewIssuePage(driver);
        loginFlow = new LoginFlow(driver);

        loginFlow.setLoginService("usuario","senha");

        viewIssuePage.setClickViewIssue();
        viewIssuePage.getViewIssue();

        assertEquals("View Issue Details [ Jump to Notes ] [ Send a reminder ]", viewIssuePage.getMessageViewDetais());
    }
}
