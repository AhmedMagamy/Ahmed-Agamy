package UiTests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.JsonFilesReader;
import utilities.ReportsUtility.TestngListener;

import java.io.IOException;

@Listeners(TestngListener.class)
public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);
    }

    @Test(description = "login with valid data")
    public void loginWithValidData() throws IOException, ParseException {
        //Read test data from external json files
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("ValidEmailAndPasswordTC.email","loginTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("ValidEmailAndPasswordTC.password","loginTestData.json");
       //Navigate to facebook
        driver.get("https://www.facebook.com/login/");
        //fill email
        loginPage.fillEmail(email);
        //fill password
        loginPage.fillPassword(password);
        //click login
        loginPage.clickLogin();
        //verify login done successfully by checking element in home page
        Assert.assertTrue(loginPage.loggedSucc());
        loginPage.doLogout();

    }
    @Test(description = "login with Invalid data")
    public void loginWithInvalidData() throws IOException, ParseException, InterruptedException {
        //Read test data from external json files
        String email = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailAndPasswordTC.email","loginTestData.json");
        String password = JsonFilesReader.readJsonDataUsingPathAsValue("InvalidEmailAndPasswordTC.password","loginTestData.json");
       //navigate to facebook login page
        driver.get("https://www.facebook.com/login/");
        //fill email field
        loginPage.fillEmail(email);
        //fill password field
        loginPage.fillPassword(password);
        //click login
        loginPage.clickLogin();
        //verify error message is displayed
        Assert.assertTrue(loginPage.isErrMsgDisplayed());

    }
}
