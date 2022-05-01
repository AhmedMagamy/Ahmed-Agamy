package endPoints;

import io.restassured.response.Response;
import utilities.ApiActions;

import java.util.HashMap;
import java.util.Map;
public class Stores {


    private ApiActions apiObject;

    public static final String BASE_URL ="http://localhost:3030";

    public Stores(ApiActions apiObject) {
        this.apiObject = apiObject;
    }

    ////////////Get list of Stores//////////

    public Response getStores(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/stores"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Get store by ID//////////

    public Response getStoreById(String id){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/stores/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Delete store by ID//////////

    public Response deleteStoreById(String id){
        return apiObject.sendRequest(ApiActions.RequestType.DELETE
                ,"/stores/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Create stores //////////
    public Response createStore(String bodyData){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");



        return apiObject.sendRequest(ApiActions.RequestType.POST
                ,"/stores"
                ,201
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }

    ////////////update store by id //////////
    public Response updateStoreById(String bodyData,String id){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");


        return apiObject.sendRequest(ApiActions.RequestType.PATCH
                ,"/stores/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }
}

