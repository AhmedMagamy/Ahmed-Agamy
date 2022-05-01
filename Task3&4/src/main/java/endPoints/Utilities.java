package endPoints;

import io.restassured.response.Response;
import utilities.ApiActions;

public class Utilities {

    private ApiActions apiObject;

    public static final String BASE_URL ="http://localhost:3030";

    public Utilities(ApiActions apiObject) {
        this.apiObject = apiObject;
    }

    ////////////Get Version//////////

    public Response getVersion(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/version"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }

    ////////////Get HealthCheck//////////

    public Response getHealthCheck(){

        return apiObject.sendRequest(ApiActions.RequestType.GET
                ,"/healthcheck"
                ,200
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null);
    }


}
