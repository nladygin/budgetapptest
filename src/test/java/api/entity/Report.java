package api.entity;

import api.helper.Utils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report extends BaseEntity implements Entity {


    public Double minAmount = 10.0;
    public Double maxAmount = 20.0;
    public String startOn;
    public String endOn;


    @PostConstruct
    public void init(){
        startOn = utils.getMonthFirstDay();
        endOn = utils.getMonthLastDay();
    }


    @Autowired private Utils utils;
}
