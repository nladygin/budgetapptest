package api;

import api.entity.Entity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static io.restassured.RestAssured.given;


@Component
public class RequestHelper {


    public Response go(String endpoint, Method method, Entity requestBody, Integer responseCode){
        return go(authHelper.getCurrentUser().token, endpoint, method, requestBody, responseCode);
    }



    public Response go(String token, String endpoint, Method method, Entity requestBody, Integer responseCode){
        log.info(method + " " + endpoint);
        log.info("token: " + authHelper.getCurrentUser().token);

        String url = config.serverURL + endpoint;
        String b = (requestBody != null) ? requestBody.asJsonString() : "";
        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + token)
                        .body(b);
        log.info("BODY: " + b);

        Response response = requestSpecification.request(String.valueOf(method), url);
        log.info("RESULT: " + response.getBody().asString());

            response.then().statusCode(responseCode);
        return response;
    }






    @Autowired private Config config;
    @Autowired private AuthHelper authHelper;
    private final Logger log = LogManager.getLogger();
}
