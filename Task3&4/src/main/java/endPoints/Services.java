package endPoints;

import io.restassured.response.Response;
import utilities.ApiActions;

import java.util.HashMap;
import java.util.Map;

public class Services {


    private ApiActions apiObject;

    public static final String BASE_URL ="http://localhost:3030";

    public Services(ApiActions apiObject) {
        this.apiObject = apiObject;
    }
    ////////////Get list of services//////////

    public Response getServices(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/services"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Get service by ID//////////

    public Response getServiceById(String id){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/services/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Delete services by ID//////////

    public Response deleteServiceById(String id){
        return apiObject.sendRequest(ApiActions.RequestType.DELETE
                ,"/services/"+id
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Create services //////////
    public Response createService(String bodyData){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");



        return apiObject.sendRequest(ApiActions.RequestType.POST
                ,"/services"
                ,201
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }

    ////////////update services by id //////////
    public Response updateServiceById(String bodyData,String id){
        Map<String,Object> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");


        return apiObject.sendRequest(ApiActions.RequestType.PATCH
                ,"/services/"+id
                ,200
                ,header
                ,null
                ,null
                ,null
                ,bodyData
                ,null);
    }
}
