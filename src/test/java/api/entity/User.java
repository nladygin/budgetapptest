package api.entity;

import org.springframework.stereotype.Component;


@Component
public class User extends BaseEntity implements Entity {


    public Integer id;
    public String username;
    public String name;
    public String createdAt;
    public String currency;
    public String token;
    public String avatar;


}
