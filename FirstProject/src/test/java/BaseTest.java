import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by bigdrop on 8/28/2017.
 */
public class BaseTest {

    public void open(WebDriver driver, String url){

        driver.get(url);
    }

    private WebDriver driver;


    private void setDriver(String browserType, String appURL) {
        if (browserType=="firefox" ) {
            driver = initFirefoxDriver(appURL);
        }
    }


    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }



}
