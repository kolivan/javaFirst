package pages;

import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import helpers.ExcelUtils;

/**
 * Created by bigdrop on 8/22/2017.
 */
public class HomePage extends BasePage {


    Wait waiter;
    public HomePage(WebDriver driver) {
       super(driver);
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
        return this;
    }
    public HomePage filledPwd(String name){
        pass.sendKeys(name);
        return this;
    }
    public HomePage clickSignInBtn() {
        click(signIn);
        return this;
    }
    public BasePage clickSubmit(){
        click(submitBtn);
        try {
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='logout']")));
            return new AccountPage(driver);
        }
        catch (NoSuchElementException e) {
            return new HomePage(driver);
        }
        catch (NullPointerException e) {
            return new HomePage(driver);
        }
    }

        public void Execute() throws Exception{
            //This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
            String sUserName = ExcelUtils.getCellData(1, 1);
            String sPassword = ExcelUtils.getCellData(1, 2);
            email.sendKeys(sUserName);
            pass.sendKeys(sPassword);
            signIn.click();

        }


}
