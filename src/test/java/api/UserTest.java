package api;

import api.entity.Password;
import api.entity.Usage;
import api.entity.User;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest extends BaseTest {

    private final String endpoint = "/users";



    @Test
    public void changeName(){
        user.name = "Test";
        Response r = requestHelper.go(user.token, endpoint, Method.PUT, user, SC_OK);
            User u = r.then().extract().as(User.class);
            assertThat(u.name, equalTo("Test"));
    }


    @Test
    public void changeCurrencySign(){
        user.currency = "RUR";
        Response r = requestHelper.go(user.token, endpoint, Method.PUT, user, SC_OK);
            User u = r.then().extract().as(User.class);
            assertThat(u.currency, equalTo("RUR"));
    }


    @Test
    public void changePassword(){
        Response r = requestHelper.go(user.token, endpoint + "/password", Method.PUT, password, SC_OK);
            assertThat(r.getBody().asString(), equalTo(""));
    }


    @Test
    public void getUsage(){
        Response r = requestHelper.go(user.token, endpoint + "/usage?" + "month=" + Calendar.getInstance().get(Calendar.MONTH) + "&year=" + Calendar.getInstance().get(Calendar.YEAR), Method.GET, null, SC_OK);
            Usage u = r.then().extract().as(Usage.class);
            assertThat(u, equalTo(usage));
    }






    @Autowired private RequestHelper requestHelper;
    @Autowired private Password password;
    @Autowired private Usage usage;
}
