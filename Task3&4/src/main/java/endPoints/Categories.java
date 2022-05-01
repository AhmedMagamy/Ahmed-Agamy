package endPoints;

import io.restassured.response.Response;
import utilities.ApiActions;

import java.util.HashMap;
import java.util.Map;

public class Categories {

    private ApiActions apiObject;

    public static final String BASE_URL ="http://localhost:3030";

    public Categories(ApiActions apiObject) {
        this.apiObject = apiObject;
    }
    ////////////Get list of Categories//////////

    public Response getCategories(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/categories"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Get Categories by ID//////////

    public Response getCategoriesById(String id){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/categories/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Delete Categories by ID//////////

    public Response deleteCategoriesById(String id){
        return apiObject.sendRequest(ApiActions.RequestType.DELETE
                ,"/categories/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Create Categories //////////
    public Response createCategories(String bodyData){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");



        return apiObject.sendRequest(ApiActions.RequestType.POST
                ,"/categories"
                ,201
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }

    ////////////update Categories by id //////////
    public Response updateCategoriesById(String bodyData,String id){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");


        return apiObject.sendRequest(ApiActions.RequestType.PATCH
                ,"/categories/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }
}
