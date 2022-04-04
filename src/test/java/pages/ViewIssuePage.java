package pages;

import bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewIssuePage extends PageBase {
    public ViewIssuePage(WebDriver driver) {
        super(driver);
    }

    private By viewIssueBy = By.linkText("View Issues");
    private By listIssueBy = By.xpath("//table[@id='buglist']//td/a[contains(text(),'000')]");
    private By messageViewDetails = By.xpath("//td[contains(text(),'View Issue Details')]");

    public void setClickViewIssue(){
        setClick(viewIssueBy);
    }

    public void getViewIssue(){
        WebElement item = getRandomElement(listIssueBy);
        item.click();
    }

    public String getMessageViewDetais(){
        return getText(messageViewDetails);
    }
}
