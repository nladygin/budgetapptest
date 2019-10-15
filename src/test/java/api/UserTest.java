package api;

import api.entity.Credentials;
import api.entity.Error;
import api.entity.Password;
import api.entity.Usage;
import api.entity.User;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest extends BaseTest {

    private final String endpoint = "/users";




    @Test
    public void checkBadSignUpEmail(){
        credentials.username = "wrongusername";
        Response r = requestHelper.go(endpoint, Method.POST, credentials, SC_BAD_REQUEST);
            Error e = r.then().extract().as(Error.class);
                assertThat(e.errors.toString(), equalTo("{username=[Email is not valid]}"));
    }


    @Test
    public void checkBadSignUpPassword(){
        credentials.username="username@test";
        credentials.password = "123";
        Response r = requestHelper.go(endpoint, Method.POST, credentials, SC_BAD_REQUEST);
            Error e = r.then().extract().as(Error.class);
                assertThat(e.errors.toString(), equalTo("{password=[Password length must be at least 6 characters]}"));
    }


    @Test
    public void changeName() throws IOException {
        User user = authHelper.getUser();
        user.name = "Test";
        Response r = requestHelper.go(endpoint, Method.PUT, user, SC_OK);
            User u = r.then().extract().as(User.class);
                assertThat(u.name, equalTo("Test"));
    }


    @Test
    public void changeCurrencySign() throws IOException {
        User user = authHelper.getUser();
        user.currency = "RUR";
        Response r = requestHelper.go(endpoint, Method.PUT, user, SC_OK);
            User u = r.then().extract().as(User.class);
                assertThat(u.currency, equalTo("RUR"));
    }


    @Test
    public void changePassword() throws IOException {
        User user = authHelper.getUser();
        Response r = requestHelper.go(endpoint + "/password", Method.PUT, password, SC_OK);
            assertThat(r.getBody().asString(), equalTo(""));
    }


    @Test
    public void getUsage() throws IOException {
        Response r = requestHelper.go(endpoint + "/usage?" + utils.getPeriod(), Method.GET, null, SC_OK);
            Usage u = r.then().extract().as(Usage.class);
//                assertThat(u, equalTo(usage));
    }






    @Autowired private RequestHelper requestHelper;
    @Autowired private AuthHelper authHelper;
    @Autowired private Password password;
    @Autowired private Usage usage;
    @Autowired private Credentials credentials;
    @Autowired private Utils utils;
}
