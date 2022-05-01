package endPointsTests;

import endPoints.Categories;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.*;
import utilities.ApiActions;
import utilities.JsonFilesReader;
import utilities.ReportsUtility.TestngListener;

import java.io.IOException;

@Listeners(TestngListener.class)
public class CategoriesTests {

    private ApiActions apiObject;
    private Categories categories;


    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(categories.BASE_URL);
        categories = new Categories(apiObject);
    }

    @Test(description = "Get list of categories")
    public void getListOfCategories() {
        Response response= categories.getCategories();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Get categories by ID")
    public void geCategoriesById() throws IOException, ParseException {
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("GetCategoryTC.id","CategoriesTestData.json");
        Response response= categories.getCategoriesById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create categories then Delete categories by ID")
    public void createCategoriesThenDeleteCategoryById() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateCategoryTC","CategoriesTestData.json");
        Response createRes =categories.createCategories(data);
        String id = createRes.jsonPath().getString("id");
        Response response= categories.getCategoriesById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create new categories")
    public void createNewCategory() throws IOException, ParseException {

        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateCategoryTC","CategoriesTestData.json");
        Response response= categories.createCategories(data);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(description = "Update created categories")
    public void updateCreatedCategory() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("UpdateCategoryTC","CategoriesTestData.json");
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("UpdateCategoryTC.id","CategoriesTestData.json");
        Response response= categories.updateCategoriesById(data,id);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }



}
