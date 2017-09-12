import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LocationPage;
import helpers.DataProviderTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by bigdrop on 8/30/2017.
 */
public class LoginTest extends BaseTest {

    HomePage homepage;
    AccountPage accountPage;
    public String url = "https://hs.bigdropinc.net/";
    User existingUser = new User("anna.kolivanova@bigdropinc.com", "Tester123");
    User existingUserWithInvalidPwd = new User("anna.kolivanova@bigdropinc.com", "Tester1234");
    User nonExistingUser = new User("anna.kolivanova123@bigdropinc.com", "Tester123");
    public String incorrectEmailOrPwd = "Incorrect email or password";
    public String emptyField = "This field can't be blank";

    @BeforeMethod
    public void beforeMethod() {

        homepage = new HomePage(driver);
        homepage.openPage(url);
    }


    @Test
    public void logInExistingUserTest() {

        homepage.clickSignInBtn()
                .filledEmail(existingUser.name)
                .filledPwd(existingUser.pass);
        homepage.clickSubmit();
        accountPage = new AccountPage(driver);
        waitThat( accountPage.logout);
    }

    @Test
    public void logInNotExistingUserTest() {

        homepage.clickSignInBtn();
        homepage.filledEmail(nonExistingUser.name);
        homepage.filledPwd(nonExistingUser.pass);
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), incorrectEmailOrPwd);
    }

    @Test
    public void logInUserWithInvalidPassTest() {

        homepage.clickSignInBtn();
        homepage.filledEmail(existingUserWithInvalidPwd.name);
        homepage.filledPwd(existingUserWithInvalidPwd.pass);
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), incorrectEmailOrPwd);
    }

    @Test
    public void LogInWithEmptyFields() {

        homepage.clickSignInBtn();
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), emptyField);
    }

    @Test(dataProvider = "Authentication", dataProviderClass = DataProviderTest.class)
    public void LogInWithDataProvider(String userName, String pwd, String expCondition){
        homepage.clickSignInBtn();
        homepage.filledEmail(userName);
        homepage.filledPwd(pwd);
        homepage.clickSubmit();
        Assert.assertEquals(homepage.note.getText(), expCondition);
    }

    @AfterTest
    public void afterMethod() {

        driver.quit();
    }
}
