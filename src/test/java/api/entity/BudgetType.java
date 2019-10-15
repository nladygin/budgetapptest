package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BudgetType extends BaseEntity implements Entity {


    public Integer id;
    public Integer createdAt;

}
