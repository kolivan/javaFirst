package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;

/**
 * Created by bigdrop on 8/29/2017.
 */
public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Dashboard")
    public WebElement dashboard;

    @FindBy(linkText = "Account Information")
    public  WebElement accountInfo;

    @FindBy(linkText = "Payment Methods")
    public WebElement paymentMethod;

    @FindBy(linkText = "My Appointments")
    public WebElement myAppointments;

    @FindBy(linkText = "Edit")
    public WebElement editBtn;

    @FindBy(linkText = "Change Password")
    public WebElement changePwd;

    @FindBy(xpath = "//div[@class='note']")
    public WebElement note;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement logout;
}
