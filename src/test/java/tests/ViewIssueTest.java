package tests;

import bases.TestBase;
import org.junit.Test;
import pages.LoginPage;
import pages.ViewIssuePage;
import static org.junit.Assert.*;

public class ViewIssueTest extends TestBase {
    LoginPage loginPage;
    ViewIssuePage viewIssuePage;

    @Test
    public void viewIssue(){
        loginPage = new LoginPage(driver);
        viewIssuePage = new ViewIssuePage(driver);

        loginPage.setUsername("usuario");
        loginPage.setPassword("senha");
        loginPage.setLogin();

        viewIssuePage.setClickViewIssue();
        viewIssuePage.getViewIssue();

        assertEquals("View Issue Details [ Jump to Notes ] [ Send a reminder ]", viewIssuePage.getMessageViewDetais());
    }
}
