package api;

import api.entity.Report;
import api.entity.Transaction;
import api.helper.Method;
import api.helper.RequestHelper;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class ReportTest extends BaseTest {

    private final String endpoint = "/reports/transactions";



    @Test
    public void getReport(){
        Response r = requestHelper.go(endpoint, Method.POST, report, SC_OK);
            ArrayList<Transaction> c = r.then().extract().as(ArrayList.class);
                assertThat(c.size(), equalTo(0));
    }










    @Autowired private RequestHelper requestHelper;
    @Autowired private Report report;
}
