package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Password extends BaseEntity implements Entity {

    public final String original = "123456";
    public final String password = "123456";
    public final String confirm = "123456";


}
