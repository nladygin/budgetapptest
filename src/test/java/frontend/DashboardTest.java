package frontend;

import frontend.action.*;
import frontend.helper.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DashboardTest extends BaseTest {


    @Test
    public void checkDashboard(){
        Double incomeValue = 11.0;
        Double actualValue = 13.0;
        Double projectedValue = 19.0;
        loginAction.auth();
        dashboardAction.open();
        Double income = dashboardAction.getIncome();
        Double projected = dashboardAction.getProjected();
        Double actual = dashboardAction.getActual();
        Double remaining = dashboardAction.getRemaining();
        newRecurringsAction
                .open()
                .add("Interest Income", incomeValue, utils.makeToday("dd/MM/yyyy"), "Daily", "dashboard income test");
        newRecurringsAction
                .open()
                .add("Cleaning", actualValue, utils.makeToday("dd/MM/yyyy"), "Daily", "dashboard actual test");
        newBudgetsAction
                .open()
                .add("Health", false, projectedValue);
        dashboardAction
                .open()
                .checkValue(income+incomeValue, dashboardAction.getIncome())
                .checkValue(projected+projectedValue, dashboardAction.getProjected())
                .checkValue(actual+actualValue, dashboardAction.getActual())
                .checkValue((projected+projectedValue)-(actual+actualValue), dashboardAction.getRemaining());
    }











    @Autowired private LoginAction loginAction;
    @Autowired private DashboardAction dashboardAction;
    @Autowired private NewRecurringsAction newRecurringsAction;
    @Autowired private Utils utils;
    @Autowired private NewBudgetsAction newBudgetsAction;
}
