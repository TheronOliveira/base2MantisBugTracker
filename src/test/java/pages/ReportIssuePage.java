package pages;

import bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportIssuePage extends PageBase {
    public ReportIssuePage(WebDriver driver) {
        super(driver);
    }

    private By reportIssueBy = By.linkText("Report Issue");
    private By projectBy = By.cssSelector("form[action='set_project.php'] select[name='project_id']");
    private By btnSelectProjectBy = By.cssSelector("input[value='Select Project']");
    private By categoryBy = By.cssSelector("select[name='category_id']");
    private By profileBy = By.cssSelector("select[name='profile_id']");
    private By assignToBy = By.cssSelector("select[name='handler_id']");
    private By summaryBy = By.cssSelector("input[name='summary']");
    private By descriptionBy = By.cssSelector("textarea[name='description']");
    private By btnSubmitReportBy = By.cssSelector("input[value='Submit Report']");
    //private By messageReportIssueSucess = By.xpath("//title[text()='View Issues - MantisBT']");
    private By messageReportIssueFailed = By.xpath("//td[contains(text(),'APPLICATION ERROR')]");

    public void setClickReportIssue(){
        setClick(reportIssueBy);
    }

    public void setProject(){
        comboBoxSelectByVisibleText(projectBy,"ProjectTatiane");
    }

    public void setClickBtnSelectProject(){
        setClick(btnSelectProjectBy);
    }

    public void setCategory(){
        comboBoxSelectByVisibleText(categoryBy,"[All Projects] General");
    }

    public void setProfile(){
        By item = By.cssSelector("select[name='profile_id'] option");
        String s = getRandomElement(item).getText();
        comboBoxSelectByVisibleText(profileBy,s);
    }

    public void setAssignTo(){
        comboBoxSelectByVisibleText(assignToBy,"theron.santos");
    }

    public void setSummary(){
        setSendKeys(summaryBy, "Teste Report Issue");
    }

    public void setDescription(){
        setSendKeys(descriptionBy,"Ocorre erro ao inserir caracteres especiais no campo endereço");
    }

    public void setClickSubmitReport(){
        setClick(btnSubmitReportBy);
    }

   // public String getMessageReportIssueSucess(){
   //     return getText(messageReportIssueSucess);
   // }

    public String getMessageReportIssueFailed(){
        return getText(messageReportIssueFailed);
    }
}
