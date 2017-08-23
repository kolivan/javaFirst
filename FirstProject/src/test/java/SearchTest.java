import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.HomePage;
import org.openqa.selenium.support.PageFactory;

public class SearchTest {

    // analyticsLoginPage mylogin = PageFactory.initElements(driver, analyticsLoginPage.class);
    //analyticsLandingPage landingpage = mylogin.login("username", "password");

    public  WebDriver driver;
     HomePage location =new HomePage(driver);

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        PageFactory.initElements(this.driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hs.bigdropinc.net/");
    }

    @Test
    public void main() {

        location.ClickLocation();
        String Actualtext = driver.findElement(By.xpath("//div[@class='container']/h1")).getText();///div[@class='container']/h1
        Assert.assertEquals(Actualtext, "Locations");
    }



    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

}