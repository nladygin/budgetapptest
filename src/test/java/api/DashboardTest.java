package api;

import api.entity.*;
import api.helper.RequestHelper;
import api.helper.Utils;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class DashboardTest extends BaseTest {

    private final String endpointUsage = "/users/usage";
    private final String endpointRecurrings = "/recurrings";
    private final String endpointBudget = "/budgets";




    @Test
    public void dashboard(){
            Usage startUsage = getUsage();

            Recurring r = postRecurring(budget);
                Usage usage2 = getUsage();
                    assertThat(usage2.income, equalTo(startUsage.income + 13));

            budget.categoryId = 2;
            budget.category.id = 2;
            Budget b = postBudget(budget);
                Usage usage3 = getUsage();
                    assertThat(usage3.projected, equalTo(startUsage.projected + 13));
                    assertThat(usage3.remaining, equalTo(startUsage.remaining + 13));
    }




    private Usage getUsage(){
        Response r = requestHelper.go(endpointUsage +"?" + utils.getPeriod(), Method.GET, null, SC_OK);
            return r.then().extract().as(Usage.class);
    }

    private Recurring postRecurring(Budget b){
        recurring.budget = b;
        Response r = requestHelper.go(endpointRecurrings, Method.POST, recurring, SC_CREATED);
            return r.then().extract().as(Recurring.class);
    }

    private Budget postBudget(Budget b){
        Response r = requestHelper.go(endpointBudget, Method.POST, b, SC_CREATED);
        return r.then().extract().as(Budget.class);
    }






    @Autowired private RequestHelper requestHelper;
    @Autowired private Utils utils;
    @Autowired private Recurring recurring;
    @Autowired private Budget budget;
    @Autowired private Category category;
}
