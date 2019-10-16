package api;

import api.entity.Category;
import api.helper.RequestHelper;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryTest extends BaseTest {

    private final String endpoint = "/categories";



    @Test
    public void getCategories(){
        Response r = requestHelper.go(endpoint, Method.GET, null, SC_OK);
            ArrayList<Category> c = r.then().extract().as(ArrayList.class);
                assertThat(c.size(), equalTo(10));
    }



    @Test
    public void createAndDeleteCategory(){
        Response r = requestHelper.go(endpoint, Method.POST, category, SC_CREATED);
            Category c = r.then().extract().as(Category.class);
                assertThat(c.name, equalTo("Test"));
                assertThat(c.type, equalTo("INCOME"));

                r = requestHelper.go(endpoint + "/" + c.id, Method.DELETE, null, SC_NO_CONTENT);
    }







    @Autowired private RequestHelper requestHelper;
    @Autowired private Category category;
}
