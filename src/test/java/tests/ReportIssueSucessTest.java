package tests;

import bases.TestBase;
import org.junit.Test;
import pages.LoginPage;
import pages.ReportIssuePage;
import static org.junit.Assert.*;

public class ReportIssueSucessTest extends TestBase {
    LoginPage loginPage;
    ReportIssuePage reportIssuePage;

    @Test
    public void registerIssue(){
        loginPage = new LoginPage(driver);
        reportIssuePage = new ReportIssuePage(driver);

        loginPage.setUsername("usuario");
        loginPage.setPassword("senha");
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
}
