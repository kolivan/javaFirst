import java.util.concurrent.TimeUnit;

import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LocationPage;

public class SearchTest extends BaseTest {

    public WebDriver driver;

    HomePage homepage;
    AccountPage accountPage;
    public String url = "https://hs.bigdropinc.net/";
    User user = new User("anna.kolivanova@bigdropinc.com", "Tester123");

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        homepage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        open(driver, url);
        homepage.clickSignInBtn();
        homepage.filledEmail(user.name);
        homepage.filledPwd(user.pass);
        homepage.clickSubmit();
        //asseertThat(accountPage.logout);
    }

    @Test
    public void logInTest() {

      // asseertThat(accountPage.myAppointments);
    }



    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}