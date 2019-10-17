package api;

import api.entity.Budget;
import api.entity.Recurring;
import api.entity.Transaction;
import api.helper.Method;
import api.helper.RequestHelper;
import io.restassured.response.Response;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class RecurringTest extends BaseTest {

    private final String endpoint = "/recurrings";



    @Test
    public void getRecurrings(){
        Response r = requestHelper.go(endpoint, Method.GET, null, SC_OK);
            ArrayList<Recurring> c = r.then().extract().as(ArrayList.class);
//                assertThat(c.size(), equalTo(0));
    }



    @Test
    public void createGetTransactionSearchAndDeleteRecurrings(){
        recurring.budget = budget;
        Response r = requestHelper.go(endpoint, Method.POST, recurring, SC_CREATED);
            Recurring re = r.then().extract().as(Recurring.class);
                assertThat(re.amount, equalTo(recurring.amount));
                assertThat(re.recurringType, equalTo(recurring.recurringType));
                assertThat(re.remark, equalTo(recurring.remark));

                r = requestHelper.go(endpoint + "/" + re.id + "/transactions", Method.GET, null, SC_OK);
                    ArrayList<Transaction> tr = r.then().extract().as(ArrayList.class);
                        assertThat(tr.size(), equalTo(1));

                            r = requestHelper.go(endpoint + "/" + re.id, Method.DELETE, null, SC_NO_CONTENT);
    }



    @Test
    @Ignore
    public void deleteWrongTransaction(){
        Response r = requestHelper.go(endpoint + "/666", Method.DELETE, null, SC_INTERNAL_SERVER_ERROR);
    }







    @Autowired private RequestHelper requestHelper;
    @Autowired private Recurring recurring;
    @Autowired private Budget budget;
}
