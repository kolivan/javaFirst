import blocks.MenuNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LocationPage;

import java.util.List;

/**
 * Created by bigdrop on 9/1/2017.
 */
public class LocationTest extends BaseTest{

    HomePage homePage;
    MenuNavigation menuNavigation;
    LocationPage locationPage;
    public String url = "https://staging.hs.bigdropinc.net/";

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
       /*locationPage.typeSearchText("08002");
       waitThat(locationPage.firstItem);
       locationPage.firstItem();
       waitThat(locationPage.moreDetails);
       locationPage.openBooking();*/

        List<WebElement> liElements = driver.findElements(By.xpath("//div[@class='location-loader']/ul[@class='list']/li"));
        System.out.println(liElements);
        int a = liElements.size();

        /*for(int i=1; i <= liElements.size(); i++)
        {
            WebElement linkElement = driver.findElement(By.xpath(".//*[@id='fk-mainhead-id']/div[2]/div/div/ul/li[" + i + "]/a"));
            System.out.println(linkElement.getText());

        }*/

    }
}
