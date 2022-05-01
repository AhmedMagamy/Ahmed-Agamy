package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.UiActions;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By errMsg = RelativeLocator.with(By.tagName("div")).below(emailField);

    private By profileImg = By.xpath("//img[@class='s45kfl79 emlxlaya bkmhp75w spb7xbtv']");
    private By logoutButton = By.xpath("//span[normalize-space()='Log Out']");






    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmail(String text){
        UiActions.type(driver,emailField,text);
    }
    public void fillPassword(String text){
        UiActions.type(driver,passwordField,text);
    }
    public void clickLogin(){
        UiActions.click(driver,loginButton);
    }
    public boolean isErrMsgDisplayed(){
        if (driver.findElement(errMsg).isDisplayed()) return true;
        else return false;
    }

    public boolean loggedSucc(){
        UiActions.locateElement(driver,profileImg);
        if (driver.findElement(profileImg).isDisplayed()) return true;
        else return false;
    }
    public void doLogout(){
        UiActions.click(driver,profileImg);
        UiActions.click(driver,logoutButton);
    }
}
