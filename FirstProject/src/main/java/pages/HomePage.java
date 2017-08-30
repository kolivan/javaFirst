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

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(xpath = "//div[@class='has-error']/div[@class='note']")
    public WebElement note;

    public HomePage filledEmail(String name){
        email.sendKeys(name);
        return new HomePage(driver);
    }
    public HomePage filledPwd(String name){
        pass.sendKeys(name);
        return new HomePage(driver);
    }
    public HomePage clickSignInBtn() {
        signIn.click();
        return new HomePage(driver);
    }
    public HomePage clickSubmit(){
        submitBtn.click();
        return new HomePage(driver);
    }


}
