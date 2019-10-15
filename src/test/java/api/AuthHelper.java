package api;

import api.entity.Credentials;
import api.entity.User;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;



@Component
public class AuthHelper {

    private final String signinEndpoint = "/users";
    private final String authEndpoint = "/users/auth";

    private User currentUser;



//    public User login(){
//        authorization();
//        return currentUser;
//    }



    public User authorization(){
        log.info("AUTHORIZATION");
        if (currentUser == null){
            log.info("NEEDED");
            signin();
            auth();
        }
        return currentUser;
    }


    private void signin(){
        RequestSpecification requestSpecification = given()
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", "Basic " + Base64.getEncoder().encodeToString((credentials.username + ":" + credentials.password).getBytes())))
                .body(credentials.asJsonString());
        Response response = requestSpecification
                .post(config.serverURL + signinEndpoint);
        currentUser = response
                .then()
                .statusCode(SC_CREATED)
                .extract()
                .as(User.class);
    }


    private void auth(){
        RequestSpecification requestSpecification = given()
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", "Basic " + Base64.getEncoder().encodeToString((credentials.username + ":" + credentials.password).getBytes())))
                .body(credentials.asJsonString());
        Response response = requestSpecification
                .post(config.serverURL + authEndpoint);
        currentUser = response
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(User.class);
    }





    public User getCurrentUser(){
        return currentUser;
    }





    @Autowired private Credentials credentials;
    @Autowired private Config config;
    private final Logger log = LogManager.getLogger();
}
