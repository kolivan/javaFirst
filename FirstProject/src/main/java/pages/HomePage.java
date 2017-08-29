package pages;

import helpers.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bigdrop on 8/22/2017.
 */
public class HomePage {
    public WebDriver driver;

    @FindBy(how=How.XPATH, using = "//li[5]/a")
    public WebElement  location;

    @FindBy(how = How.XPATH, using = "//a[@href='/account']")//
    public WebElement signIn;

    @FindBy(how = How.XPATH, using = "//input[@name='identification']")
    public WebElement email;

    @FindBy(how = How.XPATH,using = "//input[@name='password']")
    public WebElement pass;

    @FindBy(how = How.XPATH, using = "//input[@class = 'btn-blue submit']")
    public WebElement submitBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void filledField(WebElement element, String name){
        element.sendKeys(name);
    }


}
