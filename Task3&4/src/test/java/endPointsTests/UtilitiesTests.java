package endPointsTests;


import endPoints.Utilities;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ApiActions;
import utilities.ReportsUtility.TestngListener;

@Listeners(TestngListener.class)
public class UtilitiesTests {


    private ApiActions apiObject;
    private Utilities utilities;


    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(utilities.BASE_URL);
        utilities = new Utilities(apiObject);
    }

    @Test(description = "Get version")
    public void getVersion() {
        Response response= utilities.getVersion();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Get HealthCheck ")
    public void getHealthCheck() {
        Response response= utilities.getHealthCheck();
        Assert.assertEquals(response.statusCode(),200);
    }
}
