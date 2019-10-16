package api.helper;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class Utils {

    public String getPeriod(){
        return "month=" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "&year=" + Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getMonthFirstDay(){
        Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return String.valueOf(cal.getTime().toInstant().toEpochMilli()/1000);
    }

    public String getMonthLastDay(){
        Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return String.valueOf(cal.getTime().toInstant().toEpochMilli()/1000);
    }

}
