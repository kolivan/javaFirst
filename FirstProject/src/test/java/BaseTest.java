import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by bigdrop on 8/28/2017.
 */
public class BaseTest {

    public void open(WebDriver driver, String url){

        driver.get(url);
    }



}
