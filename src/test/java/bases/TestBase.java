package bases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static WebDriver driver;

    @Before
    public void beforeClassTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");
    }

    @After
    public void after() {
        driver.close();
    }

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }
}
