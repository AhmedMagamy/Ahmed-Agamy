package endPointsTests;

import endPoints.Products;
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
public class ProductsTests {

    private ApiActions apiObject;
    private Products products;


    @BeforeClass
    public void beforeClass() {

        apiObject = new ApiActions(products.BASE_URL);
        products = new Products(apiObject);
    }

    @Test(description = "Get list of products")
    public void getListOfProducts() {
        Response response= products.getProducts();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Get product by ID")
    public void getProductById() throws IOException, ParseException {
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("GetProductTC.id","ProductsTestData.json");
        Response response= products.getProductById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

        @Test(description = "Create product then Delete product by ID")
    public void createProductThenDeleteProductById() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateProductTC","ProductsTestData.json");
        Response createRes =products.createProduct(data);
        String id = createRes.jsonPath().getString("id");
        Response response= products.deleteProductById(id);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Create new product")
    public void createNewProduct() throws IOException, ParseException {

        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("CreateProductTC","ProductsTestData.json");
        Response response= products.createProduct(data);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(description = "Update created product")
    public void updateCreatedProduct() throws IOException, ParseException {
        String data = JsonFilesReader.readJsonDataUsingPathAsJsonString("UpdateProductTC","ProductsTestData.json");
        String id = JsonFilesReader.readJsonDataUsingPathAsValue("UpdateProductTC.id","ProductsTestData.json");
        Response response= products.updateProductById(data,id);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }





}
