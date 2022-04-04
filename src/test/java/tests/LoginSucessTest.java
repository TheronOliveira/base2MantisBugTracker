package tests;

import bases.TestBase;
import org.junit.*;
import pages.LoginPage;


import static org.junit.Assert.*;

public class LoginSucessTest extends TestBase {
    LoginPage loginPage;

    @Test
    public void loginSuccessfully(){
        loginPage = new LoginPage(driver);

        loginPage.setUsername("usuario");
        loginPage.setPassword("senha");
        loginPage.setLogin();

        assertEquals("Logout", loginPage.getMessageLoginSucess());
    }
}
