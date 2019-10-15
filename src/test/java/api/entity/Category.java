package api.entity;

import org.springframework.stereotype.Component;


@Component
public class Category extends BaseEntity implements Entity {


    public Integer id;
    public String name = "Test";
    public String type = "INCOME";
    public Long createdAt;
    public User user;




}
