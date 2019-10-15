package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction extends BaseEntity implements Entity {


    public Integer id;
    public String name;
    public Double amount;
    public String remark;
    public Boolean auto;
    public Long transactionOn;
    public Long createdAt;
    public Budget budget;
    public Recurring recurring;


}
