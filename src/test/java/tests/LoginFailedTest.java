package tests;

import bases.TestBase;
import org.junit.Test;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginFailedTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void loginFailed(){
        String msg = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        loginPage = new LoginPage(driver);

        loginPage.setUsername("usuario");
        loginPage.setPassword("senha");
        loginPage.setLogin();

        assertEquals(msg,loginPage.getMessageLoginFailed());
    }
}
