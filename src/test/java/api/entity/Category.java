package api.entity;

import api.AuthHelper;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseEntity implements Entity {


    public Integer id;
    public String name = "Test";
    public String type = "INCOME";
    public Long createdAt;
    public User user;



    @PostConstruct
    public void init() throws IOException {
        this.user = authHelper.getUser();
        this.createdAt = System.currentTimeMillis();
    }


    @Autowired private AuthHelper authHelper;
}
