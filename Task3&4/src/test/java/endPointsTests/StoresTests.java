package endPointsTests;

import endPoints.Stores;
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
public class StoresTests {

    private ApiActions apiObject;
    private Stores stores;


    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(stores.BASE_URL);
        stores = new Stores(apiObject);
    }

    @Test(description = "Get list of stores")
    public void getListOfStores() {
        Response response= stores.getStores();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Get store by ID")
    public void geStoreById() throws IOException, ParseException {
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("GetStoreTC.id","StoresTestData.json");
        Response response= stores.getStoreById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create store then Delete product by ID")
    public void createStoreThenDeleteStoreById() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateStoreTC","StoresTestData.json");
        Response createRes =stores.createStore(data);
        String id = createRes.jsonPath().getString("id");
        Response response= stores.deleteStoreById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create new Store")
    public void createNewStore() throws IOException, ParseException {

        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateStoreTC","StoresTestData.json");
        Response response= stores.createStore(data);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(description = "Update created Store")
    public void updateCreatedStore() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("UpdateStoreTC","StoresTestData.json");
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("UpdateStoreTC.id","StoresTestData.json");
        Response response= stores.updateStoreById(data,id);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }




}
