package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LocationPage;

/**
 * Created by bigdrop on 9/1/2017.
 */
public class MenuNavigation {

    private WebDriver driver;

    public MenuNavigation(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Massage")
    public WebElement message;

    @FindBy(linkText = "Facials")
    public WebElement facials;

    @FindBy(linkText = "Hair Removal")
    public WebElement hairRemoval;

    @FindBy(linkText = "Spa Deals")
    public WebElement spaDeals;

    @FindBy(linkText = "Locations")
    public WebElement locations;

    public LocationPage openLocationPage(){
        locations.click();
        return new LocationPage(driver);
    }
}
