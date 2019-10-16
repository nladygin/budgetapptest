package api.helper;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Utils {

    public String getPeriod(){
        return "month=" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "&year=" + Calendar.getInstance().get(Calendar.YEAR);
    }

}
