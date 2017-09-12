import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by bigdrop on 9/1/2017.
 */
public class RegularBookingTest extends BaseTest {

    HomePage homepage;
    public String url = "https://hs.bigdropinc.net/";
    private static final String path = "src/main/resources/location.csv";

    @BeforeMethod()
    public void beforemethod() {
        homepage = new HomePage(driver);
        homepage.openPage(url);
    }

    @Test
    public void openLocation() {
        File file=new File("C:\\Users\\bigdrop.DESKTOP-9JVHO99\\IdeaProjects\\FirstProject\\src\\test\\location.csv");
        Scanner testScanner = new Scanner(new BufferedReader(new FileReader(file)));

        while (testScanner.hasNextLine())
        {
            System.out.println(testScanner.nextLine());
        }
    }
}