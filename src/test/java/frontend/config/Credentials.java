package frontend.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Credentials {
    public String username = "test@test";
    public String password = "123456";
}
