package pages;

import bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameBy = By.cssSelector("input[name='username']");
    private By passwordBy = By.cssSelector("input[name='password']");
    private By btnLoginBy = By.cssSelector("input[type='submit']");
    private By loginSucessBy = By.xpath("//a[text()='Logout']");
    private By loginFailedBy = By.xpath("//div[font[contains(text(),'Your account may be disable')]]");



    public void setUsername(String username) {
        setSendKeys(usernameBy,username);
    }

    public void setPassword(String password) {
        setSendKeys(passwordBy,password);
    }

    public void setLogin() {
        setClick(btnLoginBy);
    }

    public String getMessageLoginSucess(){
        return getText(loginSucessBy);
    }

    public String getMessageLoginFailed(){
        return getText(loginFailedBy);
    }
}
