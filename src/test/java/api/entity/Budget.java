package api.entity;

import org.springframework.stereotype.Component;


@Component
public class Budget extends BaseEntity implements Entity {


    public Integer id;
    public String name = "Test";
    public Double projected = 13.0;
    public Double actual;
    public Long period;
    public Long createdAt;
    public Category category;
    public BudgetType budgetType;
    public Integer categoryId = 1;

}
