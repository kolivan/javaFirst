import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class SearchTest {

    public WebDriver driver;

    @Test
    public void main() {
        driver.findElement(By.id("ember699")).click();

    }

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hs.bigdropinc.net/");
        String Actualtext = driver.findElement(By.xpath("//*[@id=\"ember575\"]/div[4]/nav/div/div/p")).getText();
        Assert.assertEquals(Actualtext, "Tuesday, 28 January 2014");
    }

    @AfterMethod
    public void afterMethod() {


        driver.quit();

    }

}