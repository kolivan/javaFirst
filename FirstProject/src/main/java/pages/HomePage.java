package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 8/22/2017.
 */
public class HomePage {
    public WebDriver driver;

    public WebElement getLocation() {
        return location;
    }

    @FindBy(css = "a[id=ember699]")
    public WebElement  location;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void ClickLocation(){
        location.click();
    }

}
