package UiTests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.JsonFilesReader;
import utilities.ReportsUtility.TestngListener;

import java.io.IOException;

@Listeners(TestngListener.class)
public class RegistrationTests extends BaseTest {
    private RegistrationPage registrationPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        registrationPage = new RegistrationPage(driver);
    }
    @Test(description = "Register with valid data")
    public void registerWithValidData() throws IOException, ParseException {
        //Read test data from external json file
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.email","RegisterTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.password","RegisterTestData.json");
        String firstName = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.firstname","RegisterTestData.json");
        String lastname = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.lastname","RegisterTestData.json");
        String birthday = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.birthday","RegisterTestData.json");
        String birthmonth = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.birthmonth","RegisterTestData.json");
        String birthyear = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.birthyear","RegisterTestData.json");
        String gender = JsonFilesReader.readJsonDataUsingPathAsValue("ValidRegisterTC.gender","RegisterTestData.json");
        //open facebook
        driver.get("https://www.facebook.com/login");
        //open registration page
        registrationPage.clickCreateAccount();
        //fill data
        registrationPage.fillFirstName(firstName);
        registrationPage.fillLastName(lastname);
        registrationPage.fillEmail(email);
        registrationPage.fillConfirmEmail(email);
        registrationPage.fillPassword(password);
        registrationPage.selectBirthDate(birthday,birthmonth,birthyear);
        registrationPage.selectGender(gender);
        //submit
        registrationPage.clickSubmit();
        //Verify register done successfully by checking element in home page
        Assert.assertTrue(registrationPage.registeredSucc());
        registrationPage.doLogout();
    }
    @Test(description = "Register with invalid email ")
    public void registerWithInvalidEmail() throws IOException, ParseException {
        //Read test data from external json file
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.email","RegisterTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.password","RegisterTestData.json");
        String firstName = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.firstname","RegisterTestData.json");
        String lastname = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.lastname","RegisterTestData.json");
        String birthday = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.birthday","RegisterTestData.json");
        String birthmonth = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.birthmonth","RegisterTestData.json");
        String birthyear = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.birthyear","RegisterTestData.json");
        String gender = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailRegisterTC.gender","RegisterTestData.json");
        //open facebook
        driver.get("https://www.facebook.com/login");
        //open registration page
        registrationPage.clickCreateAccount();
        //fill data
        registrationPage.fillFirstName(firstName);
        registrationPage.fillLastName(lastname);
        registrationPage.fillEmail(email);
       // registrationPage.fillConfirmEmail(email);
        registrationPage.fillPassword(password);
        registrationPage.selectBirthDate(birthday,birthmonth,birthyear);
        registrationPage.selectGender(gender);
        //submit
        registrationPage.clickSubmit();
        //Verify the error message is displayed
        Assert.assertTrue(registrationPage.isValidationMsgDisplayed("Please enter a valid mobile number or email address"));
    }
    @Test(description = "Register with Empty email ")
    public void registerWithEmptyEmail() throws IOException, ParseException {
        //Read test data from external json file
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.email","RegisterTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.password","RegisterTestData.json");
        String firstName = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.firstname","RegisterTestData.json");
        String lastname = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.lastname","RegisterTestData.json");
        String birthday = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.birthday","RegisterTestData.json");
        String birthmonth = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.birthmonth","RegisterTestData.json");
        String birthyear = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.birthyear","RegisterTestData.json");
        String gender = JsonFilesReader.readJsonDataUsingPathAsValue("EmptyEmailRegisterTC.gender","RegisterTestData.json");
        //open facebook
        driver.get("https://www.facebook.com/login");
        //open registration page
        registrationPage.clickCreateAccount();
        //fill data
        registrationPage.fillFirstName(firstName);
        registrationPage.fillLastName(lastname);
        registrationPage.fillEmail(email);
        // registrationPage.fillConfirmEmail(email);
        registrationPage.fillPassword(password);
        registrationPage.selectBirthDate(birthday,birthmonth,birthyear);
        registrationPage.selectGender(gender);
        //submit
        registrationPage.clickSubmit();
        //Verify the error message is displayed
        Assert.assertTrue(registrationPage.isValidationMsgDisplayed("You'll use this when you log in and if you ever need to reset your password."));
    }
    @Test(description = "Emails doesn't match ")
    public void emailsDosntMtach() throws IOException, ParseException {
        //Read test data from external json file
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.email","RegisterTestData.json");
        String emailConf = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.emailconf","RegisterTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.password","RegisterTestData.json");
        String firstName = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.firstname","RegisterTestData.json");
        String lastname = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.lastname","RegisterTestData.json");
        String birthday = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.birthday","RegisterTestData.json");
        String birthmonth = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.birthmonth","RegisterTestData.json");
        String birthyear = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.birthyear","RegisterTestData.json");
        String gender = JsonFilesReader.readJsonDataUsingPathAsValue("EmailsDoesntMatchRegisterTC.gender","RegisterTestData.json");
        //open facebook
        driver.get("https://www.facebook.com/login");
        //open registration page
        registrationPage.clickCreateAccount();
        //fill data
        registrationPage.fillFirstName(firstName);
        registrationPage.fillLastName(lastname);
        registrationPage.fillEmail(email);
         registrationPage.fillConfirmEmail(emailConf);
        registrationPage.fillPassword(password);
        registrationPage.selectBirthDate(birthday,birthmonth,birthyear);
        registrationPage.selectGender(gender);
        //submit
        registrationPage.clickSubmit();
        //Verify the error message is displayed
        Assert.assertTrue(registrationPage.isValidationMsgDisplayed("Your emails do not match. Please try again."));
    }
}
