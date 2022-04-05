package flows;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginFlow {
    protected WebDriver driver = null;

    //Objects and constructor
    LoginPage loginPage;

    public LoginFlow(WebDriver driver){
        //Page and Steps Objects
        loginPage = new LoginPage(driver);
        this.driver = driver;
    }

    //Flows
    public void setLoginService(String usuario, String senha){
        loginPage.setUsername(usuario);
        loginPage.setPassword(senha);
        loginPage.setLogin();
    }
}
