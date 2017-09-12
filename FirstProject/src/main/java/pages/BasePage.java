package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 8/23/2017.
 */
public class BasePage {

    private WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage (String URL) {
        driver.get(URL);
    }

    public void click(WebElement element) {
        element.click();
    }



}
