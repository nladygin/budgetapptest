package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;




@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usage extends BaseEntity implements Entity {

    public Double income = 0.0;
    public Double projected = 0.0;
    public Double actual = 0.0;
    public Double remaining = 0.0;

}
