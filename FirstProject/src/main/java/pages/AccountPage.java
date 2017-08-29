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
    @FindBy(xpath = "//a[@class='/acount']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[@href='/account/information']")
    public  WebElement accountInfo;

    @FindBy(xpath = "//a[@href='/account/payment'")
    public WebElement paymentMethod;

    @FindBy(xpath = "//a[@href='/account/appointments'")
    public WebElement myAppointments;

    @FindBy(xpath = "//a[@class='/link btn-turquoise ember-view'")
    public WebElement editBtn;
}
