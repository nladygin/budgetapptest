package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Credentials extends BaseEntity implements Entity {
    public String username = "test@test";
    public String password = "123456";
}
