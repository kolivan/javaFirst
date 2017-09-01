import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

/**
 * Created by bigdrop on 9/1/2017.
 */
public class RegularBookingTest extends BaseTest{

    HomePage homepage;
    public String url = "https://hs.bigdropinc.net/";

    @BeforeMethod()
    public void beforemethod() {
        homepage = new HomePage(driver);
        homepage.openPage(url);

    }
}
