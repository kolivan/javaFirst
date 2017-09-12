package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by bigdrop on 9/11/2017.
 */
public class DataProviderTest {


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][]{{"anna.kolivanova@bigdropinc.com", "Test12388", "Incorrect email or password"}, {"anna.kolivanova@bigdropinc.com", "Test123888","Incorrect email or password"}};

    }
}