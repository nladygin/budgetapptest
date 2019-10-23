package frontend;

import frontend.action.*;
import frontend.helper.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReportsTest extends BaseTest {


    @Test
    public void checkReportByValue(){
        Double incomeValue = 33.0;
        loginAction.auth();
        reportsAction
                .open()
                .setFilter(incomeValue-1, incomeValue+1, "","");
        int resultNumber = reportsAction.getResultNumber();
        newRecurringsAction
                .open()
                .add("Transfer From Savings", incomeValue, utils.makeToday("dd/MM/yyyy"), "Daily", "report income test");
        reportsAction
                .open()
                .setFilter(incomeValue-1, incomeValue+1, "","")
                .checkResult(resultNumber + 1, reportsAction.getResultNumber());
    }


    @Test
    public void checkReportByDate(){
        loginAction.auth();
        reportsAction
                .open()
                .setFilter(null, null, utils.makeToday("dd/MM/yyyy", 30), utils.makeToday("dd/MM/yyyy", 30))
                .checkResult(0, reportsAction.getResultNumber());
    }










    @Autowired private LoginAction loginAction;
    @Autowired private ReportsAction reportsAction;
    @Autowired private NewRecurringsAction newRecurringsAction;
    @Autowired private Utils utils;
}
