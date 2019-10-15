package api.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class Recurring extends BaseEntity implements Entity {


    public Integer id;
    public Double amount = 13.0;
    public String recurringType = "DAILY";
    public Long lastRunAt;
    public Long createdAt;
    public BudgetType budgetType;
    public String remark = "remark";
    public String transactions;
    public String name = "Test";
    public String recurringTypeDisplay;
    public Integer budgetId = 1;
    public String recurringAt = String.valueOf(new Timestamp(System.currentTimeMillis()).toInstant().toEpochMilli());;
    public Budget budget;


}
