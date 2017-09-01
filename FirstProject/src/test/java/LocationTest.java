import blocks.MenuNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LocationPage;

/**
 * Created by bigdrop on 9/1/2017.
 */
public class LocationTest extends BaseTest{

    HomePage homePage;
    MenuNavigation menuNavigation;
    LocationPage locationPage;
    public String url = "https://hs.bigdropinc.net/";

    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        menuNavigation = new MenuNavigation(driver);
        locationPage = new LocationPage(driver);
        homePage = new HomePage(driver);
        homePage.openPage(url);
    }

    @Test
    public void openLocationPage(){
       menuNavigation.openLocationPage();
       locationPage.typeSearchText("08002");
       waitThat(locationPage.firstItem);
       locationPage.firstItem();
       waitThat(locationPage.moreDetails);
       locationPage.openBooking();

    }
}
