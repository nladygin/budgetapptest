package api.entity;

import org.springframework.stereotype.Component;


@Component
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
