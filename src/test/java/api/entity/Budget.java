package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Budget extends BaseEntity implements Entity {


    public Integer id;
    public String name = "Test";
    public Double projected = 13.0;
    public Double actual = 13.0;
    public Long period;
    public Long createdAt;
    public Category category;
    public BudgetType budgetType;
    public Integer categoryId = 1;



    @PostConstruct
    public void init(){
        this.category = cat;
    }


    @Autowired private Category cat;
}
