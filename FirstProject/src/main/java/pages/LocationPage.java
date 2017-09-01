package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 8/22/2017.
 */
public class LocationPage extends BasePage{
    //WebDriver driver;

    public LocationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='container']/h1")
    public WebElement title;

    @FindBy (xpath = "//div[@class='wrap-autocomplete ember-view']/input")
    public WebElement searchBox;

    @FindBy(xpath = "//form/input[@class=btn-blue submit]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='info']")
    public WebElement infoBlock;

    @FindBy(xpath ="//div[@class='location-loader ']")
    public WebElement loader;

    @FindBy(xpath = "//div[@class='wrap-autocomplete ember-view']/ul/li[1]")
    public WebElement firstItem;

    @FindBy(linkText = "More details")
    public WebElement moreDetails;

    public LocationPage typeSearchText(String searchText){
        searchBox.sendKeys(searchText);
        return this;
    }

    public void firstItem(){
        firstItem.click();
    }

    public void openBooking(){
        moreDetails.click();
    }

}
