package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity implements Entity {


    public Integer id;
    public String username;
    public String name;
    public String createdAt;
    public String currency;
    public String token;
    public String avatar;


}
