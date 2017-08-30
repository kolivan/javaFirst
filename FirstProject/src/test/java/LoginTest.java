import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LocationPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by bigdrop on 8/30/2017.
 */
public class LoginTest extends BaseTest {

    public WebDriver driver;

    HomePage homepage;
    public String url = "https://hs.bigdropinc.net/";
    User existingUser = new User("anna.kolivanova@bigdropinc.com", "Tester123");
    User existingUserWithInvalidPwd = new User("anna.kolivanova@bigdropinc.com", "Tester1234");
    User nonExistingUser = new User("anna.kolivanova123@bigdropinc.com", "Tester123");
    public  String incorrectEmailOrPwd="Incorrect email or password";
    public String emptyField = "This field can't be blank";

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        homepage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        open(driver, url);

    }

    @Test
    public void logInExistingUserTest() {
        homepage.clickSignInBtn();
        homepage.filledEmail(existingUser.name);
        homepage.filledPwd(existingUser.pass);
        homepage.clickSubmit();
        /*AccountPage apage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Appointments")));
        Assert.assertEquals(apage.myAppointments.getText(), "MY APPOINTMENTS");/*/
    }
    @Test
    public void logInNotExistingUserTest(){
        homepage.clickSignInBtn();
        homepage.filledEmail(nonExistingUser.name);
        homepage.filledPwd(nonExistingUser.pass);
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), incorrectEmailOrPwd);
    }
    @Test
    public void logInUserWithInvalidPassTest(){
        homepage.clickSignInBtn();
        homepage.filledEmail(existingUserWithInvalidPwd.name);
        homepage.filledPwd(existingUserWithInvalidPwd.pass);
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), incorrectEmailOrPwd);
    }
    @Test
    public  void LogInWithEmptyFields(){
        homepage.clickSignInBtn();
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), emptyField);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
