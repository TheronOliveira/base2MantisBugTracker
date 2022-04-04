package bases;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public PageBase(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) driver;
    }

    private void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= 30)
        {
            String documentState = js.executeScript("return document.readyState").toString();
            if (documentState.equals("complete")){
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator){
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }
    protected WebElement waitForElementVisible(By locator){
        waitUntilPageReady();
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void comboBoxSelectByVisibleText(By locator, String text){
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    protected void setSendKeys(By locator, String text){
        waitUntilPageReady();
        driver.findElement(locator).sendKeys(text);
    }

    protected void setClick(By locator){
        driver.findElement(locator).click();
    }

    protected String getText(By locator){
        String text = waitForElementVisible(locator).getText();
        return text;
    }

    public WebElement getRandomElement(By locator) {
        Random rand = new Random();
        List<WebElement> list = driver.findElements(locator);
        WebElement item = list.get(rand.nextInt(list.size()));
        return item;
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

}
