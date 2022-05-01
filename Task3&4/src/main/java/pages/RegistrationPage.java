package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.UiActions;

public class RegistrationPage {
    private WebDriver driver;
    By createAccButton = By.xpath("//a[normalize-space()='Create New Account']");
    By firstNameField = By.xpath("//input[@name='firstname']");
    By surNameField = By.xpath("//input[@name='lastname']");
    By emailField = By.xpath("//input[@name='reg_email__']");
    By reEmailField = By.xpath("//input[@name='reg_email_confirmation__']");

    By passwordField = By.xpath("//input[@name='reg_passwd__']");
    By birthdaySelect = By.id ("day");
    By birthMonthSelect = By.id ("month");
    By birthYearSelect = By.id ("year");
    By maleGenderRadioBtn = By.xpath ("//label[normalize-space()='Male']");
    By femaleGenderRadioBtn = By.xpath ("//label[normalize-space()='Female']");
    By customGenderRadioBtn = By.xpath ("//label[normalize-space()='Custom']");
    By submitButton = By.xpath("//button[@name=\"websubmit\"]");
    By homeDropDownArrow = By.xpath("//div[@aria-label=\"More options\"]");
    By logoutButton = By.xpath("//span[normalize-space()='Log Out']");
    By secondLogoutButton = By.xpath("(//div[@class='rq0escxv l9j0dhe7 du4w35lb j83agx80 cbu4d94t d2edcug0 hpfvmrgz buofh1pr g5gj957u ph5uu5jm b3onmgus e5nlhep0 ecm0bbzt mg4g778l'])[2]");



    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccount(){
        UiActions.click(driver,createAccButton);
    }
    public void fillFirstName(String text){
        UiActions.type(driver,firstNameField,text);
    }
    public void fillLastName(String text){
        UiActions.type(driver,surNameField,text);
    }
    public void fillEmail(String text){
        UiActions.type(driver,emailField,text);
    }
    public void fillConfirmEmail(String text){
        UiActions.type(driver,reEmailField,text);
    }
    public void fillPassword(String text){
        UiActions.type(driver,passwordField,text);
    }
    public void selectBirthDate(String day ,String month , String year){

        UiActions.select(driver,birthdaySelect,"text",day);
        UiActions.select(driver,birthMonthSelect,"text",month);
        UiActions.select(driver,birthYearSelect,"text",year);
    }
    public void selectGender(String gender){
        switch (gender) {
            case "male" -> UiActions.click(driver,maleGenderRadioBtn);
            case "female" -> UiActions.click(driver,femaleGenderRadioBtn);
            case "custom" -> UiActions.click(driver,customGenderRadioBtn);
        }
    }

    public void clickSubmit(){
        UiActions.click(driver,submitButton);
    }

    public void doLogout(){
        UiActions.click(driver,homeDropDownArrow);
        UiActions.click(driver,logoutButton);
        UiActions.click(driver,secondLogoutButton);
    }

    public Boolean registeredSucc(){
        UiActions.locateElement(driver,homeDropDownArrow);
        if (driver.findElement(homeDropDownArrow).isDisplayed()) return  true;
        else return false;
    }

    public  Boolean isValidationMsgDisplayed(String errTxt){
        if(driver.getPageSource().contains(errTxt)) return true;
        else return false;
    }
}
