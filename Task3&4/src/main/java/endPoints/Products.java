package endPoints;

import io.restassured.response.Response;
import utilities.ApiActions;

import java.util.HashMap;
import java.util.Map;

public class Products {

    private ApiActions apiObject;

    public static final String BASE_URL ="http://localhost:3030";

    public Products(ApiActions apiObject) {
        this.apiObject = apiObject;
    }



    ////////////Get list of products//////////

    public Response getProducts(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/products"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Get product by ID//////////

    public Response getProductById(String id){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/products/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Delete product by ID//////////

    public Response deleteProductById(String id){
        return apiObject.sendRequest(ApiActions.RequestType.DELETE
                ,"/products/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Create products //////////
    public Response createProduct(String bodyData){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");



        return apiObject.sendRequest(ApiActions.RequestType.POST
                ,"/products"
                ,201
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }

    ////////////update product by id //////////
    public Response updateProductById(String bodyData,String id){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");


        return apiObject.sendRequest(ApiActions.RequestType.PATCH
                ,"/products/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }
}
