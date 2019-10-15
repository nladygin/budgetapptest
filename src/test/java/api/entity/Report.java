package api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report extends BaseEntity implements Entity {


    public Double minAmount = 10.0;
    public Double maxAmount = 20.0;
    public String startOn;
    public String endOn;


    @PostConstruct
    public void init(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
                startOn = String.valueOf(cal.getTime().toInstant().toEpochMilli()/1000);

            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                endOn = String.valueOf(cal.getTime().toInstant().toEpochMilli()/1000);
    }

}
