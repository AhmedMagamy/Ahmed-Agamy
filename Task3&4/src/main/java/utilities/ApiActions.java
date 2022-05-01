package utilities;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import utilities.ReportsUtility.ExtentReport;

import java.util.Map;

import static org.testng.Assert.fail;

public class ApiActions {

    private RequestSpecification request;
    private Response response;
    private QueryableRequestSpecification queryableRequestSpecs;
    private String baseUrl;
    public enum RequestType {
        POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE"), PATCH("PATCH");

        private String value;

        RequestType(String type) {
            this.value = type;
        }

        String getValue() {
            return value;
        }
    }

    public ApiActions(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    private RequestSpecification requestSpec = new RequestSpecBuilder()
//	    .setBaseUri(baseURI)
            .log(LogDetail.ALL).build();

    public Response sendRequest(RequestType requestType
            , String serviceName
            , int expectedStatusCode
            , Map<String, Object> headers
            , ContentType contentType
            , Map<String, Object> formParams
            , Map<String, Object> queryParams
            , Object body
            , Map<String,String> cookies) {

        String requestUrl = baseUrl + serviceName;
        if(serviceName == null){
            requestUrl = baseUrl+"";
        }
        //to avoid ssl validations errors in some APIs
        RestAssured.useRelaxedHTTPSValidation();
        //start building the request
        request = RestAssured.given().spec(requestSpec);
        queryableRequestSpecs = SpecificationQuerier.query(request);
        Logger.logMessage("Request URL: [" + requestUrl + "] | Request Method: [" + requestType.getValue()
                + "] | Expected Status Code: [" + expectedStatusCode + "]");
        try {

            if (headers != null) {
                request.headers(headers);
                String qHeaders = queryableRequestSpecs.getHeaders().toString();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Headers: " + "\n" + qHeaders));
            }
            if (contentType != null) {
                request.contentType(contentType);
                String qContentType = queryableRequestSpecs.getContentType();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Content Type: " + qContentType));
            }
            if (formParams != null) {
                request.formParams(formParams);
                String qFormParams = queryableRequestSpecs.getFormParams().toString();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Form params: " + "\n" + qFormParams));
            }
            if (queryParams != null) {
                request.queryParams(queryParams);
                String qQueryParams = queryableRequestSpecs.getQueryParams().toString();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Query params: " + "\n" + qQueryParams));
            }
            if (body != null) {
                request.body(body);
                String qBody = queryableRequestSpecs.getBody().toString();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Body: " + "\n" + qBody));
            }
            if (cookies != null) {
                request.cookies(cookies);
                String qCookies = queryableRequestSpecs.getCookies().toString();
                ExtentReport.info(MarkupHelper.createCodeBlock("Request Cookies: " + "\n" + qCookies));
            }

            switch (requestType){
                case  GET ->   response = request.get(requestUrl);
                case  POST ->  response = request.post(requestUrl);
                case  PUT ->   response = request.put(requestUrl);
                case  DELETE ->response = request.delete(requestUrl);
                case  PATCH -> response = request.patch(requestUrl);
            }
           // response.then().spec(responseSpec).statusCode(expectedStatusCode);
        } catch (Exception e) {
            //log any throwable to the report and to the console
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
        //attach to ExtentReport
        ExtentReport.info(MarkupHelper.createCodeBlock("API Response: " + "\n" + response.asPrettyString()));
        return response;
    }


}
