package endPointsTests;

import endPoints.Services;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ApiActions;
import utilities.JsonFilesReader;
import utilities.ReportsUtility.TestngListener;

import java.io.IOException;

@Listeners(TestngListener.class)
public class ServicesTests {


    private ApiActions apiObject;
    private Services services;


    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(services.BASE_URL);
        services = new Services(apiObject);
    }

    @Test(description = "Get list of services")
    public void getListOfServices() {
        Response response= services.getServices();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Get service by ID")
    public void geServiceById() throws IOException, ParseException {
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("GetServiceTC.id","ServicesTestData.json");
        Response response= services.getServiceById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create service then Delete service by ID")
    public void createServiceThenDeleteServiceById() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateServiceTC","ServicesTestData.json");
        Response createRes =services.createService(data);
        String id = createRes.jsonPath().getString("id");
        Response response= services.getServiceById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create new Service")
    public void createNewService() throws IOException, ParseException {

        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateServiceTC","ServicesTestData.json");
        Response response= services.createService(data);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(description = "Update created Service")
    public void updateCreatedService() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("UpdateServiceTC","ServicesTestData.json");
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("UpdateServiceTC.id","ServicesTestData.json");
        Response response= services.updateServiceById(data,id);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }



}
