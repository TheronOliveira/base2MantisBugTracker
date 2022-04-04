package tests;

import bases.TestBase;
import org.junit.Test;
import pages.LoginPage;
import pages.ReportIssuePage;
import static org.junit.Assert.*;

public class ReportIssueFailedTest extends TestBase {
    LoginPage loginPage;
    ReportIssuePage reportIssuePage;

    @Test
    public void registerIssueFailed() {
        loginPage = new LoginPage(driver);
        reportIssuePage = new ReportIssuePage(driver);

        loginPage.setUsername("usuario");
        loginPage.setPassword("senha");
        loginPage.setLogin();

        reportIssuePage.setClickReportIssue();
        reportIssuePage.setClickBtnSelectProject();
        reportIssuePage.setClickSubmitReport();

        assertEquals("APPLICATION ERROR #11", reportIssuePage.getMessageReportIssueFailed());
    }
}
