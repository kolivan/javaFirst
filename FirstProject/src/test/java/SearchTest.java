import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

    //public WebDriver driver;

    HomePage homepage;
    AccountPage accountPage;
    public String url = "https://hs.bigdropinc.net/";
    User user = new User("anna.kolivanova@bigdropinc.com", "Tester1234");

    @BeforeClass
    public void beforeMethod() {
        homepage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        homepage.openPage(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepage.clickSignInBtn();
        homepage.filledEmail(user.name);
        homepage.filledPwd(user.pass);
        homepage.clickSubmit();
        waitThat(homepage.signIn);


    }

    @Test
    public void logInTest() {
        homepage.clickSignInBtn();
        waitThat(accountPage.accountInfo);
    }



    /*@AfterMethod
    public void afterMethod() {
        driver.quit();
    }*/
}