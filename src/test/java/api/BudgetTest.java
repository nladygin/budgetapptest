package api;

import api.entity.Budget;
import api.entity.Category;
import api.helper.AuthHelper;
import api.helper.Method;
import api.helper.RequestHelper;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class BudgetTest extends BaseTest {

    private final String endpoint = "/budgets";



    @Test
    public void getBudgets() {
        Response r = requestHelper.go(endpoint, Method.GET, null, SC_OK);
            ArrayList<Budget> c =  r.then().extract().as(ArrayList.class);
                assertThat(c.size(), equalTo(65));
    }



    @Test
    public void createAndDeleteBudget() throws IOException {
        Response r = requestHelper.go(endpoint, Method.POST, budget, SC_CREATED);
            Budget b = r.then().extract().as(Budget.class);
                assertThat(b.name, equalTo("Test"));
                assertThat(b.projected, equalTo(13.0));
                assertThat(b.category.id, equalTo(1));

                    r = requestHelper.go(endpoint + "/" + b.id, Method.DELETE, null, SC_NO_CONTENT);
    }


    @Test
    public void deleteWrongBudget(){
        Response r = requestHelper.go(endpoint + "/666", Method.DELETE, null, SC_NOT_FOUND);
    }







    @Autowired private RequestHelper requestHelper;
    @Autowired private AuthHelper authHelper;
    @Autowired private Budget budget;
    @Autowired private Category category;
}
