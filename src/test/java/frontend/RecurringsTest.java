package frontend;

import frontend.action.*;
import frontend.helper.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RecurringsTest extends BaseTest {


    @Test
    public void searchRecurring(){
        loginAction.auth();
        recurringsAction.open();
        addRecurring("Phone", 13.0, utils.makeToday("dd/MM/yyyy"), "Daily", "test searchable daily recurring");
        newRecurringsAction.checkSuccessMessage("Successfully created Recurring");
        recurringsAction
                .open()
                .search("searchable")
                .checkSearchResult(1);
    }


    @Test
    public void searchNonexistentBudget(){
        loginAction.auth();
        recurringsAction
                .open()
                .search("nonexistentrecurring")
                .checkSearchResult(0);
    }


    @Test
    public void addRecurring(){
        loginAction.auth();
        addRecurring("Internet", 13.0, utils.makeToday("dd/MM/yyyy"), "Daily", "test daily recurring");
        newRecurringsAction.checkSuccessMessage("Successfully created Recurring");
    }


    @Test
    public void deleteRecurring(){
        String budget = "Fuel";
        loginAction.auth();
        addRecurring(budget, 13.0, utils.makeToday("dd/MM/yyyy"), "Daily", "test " + budget + " daily recurring");
        deleteRecurring(budget);
    }


    @Test
    public void addRecurringWithEmptyBudget(){
        loginAction.auth();
        addRecurring("", 13.0, utils.makeToday("dd/MM/yyyy"), "Daily", "test daily recurring");
        newRecurringsAction.checkAlertMessage("Budget is required");
    }


    @Test
    public void addRecurringWithEmptyAmount(){
        loginAction.auth();
        addRecurring("Fuel", null, utils.makeToday("dd/MM/yyyy"), "Daily", "test daily recurring");
        newRecurringsAction.checkAlertMessage("Amount is required");
    }


    @Test
    public void addRecurringWithEmptyDate(){
        loginAction.auth();
        addRecurring("Fuel", 13.0, null, "Daily", "test daily recurring");
        newRecurringsAction.checkAlertMessage("Recurring Date is required");
    }


    @Test
    public void addRecurringWithEmptyType(){
        loginAction.auth();
        addRecurring("Fuel", 13.0, utils.makeToday("dd/MM/yyyy"), "", "test daily recurring");
        newRecurringsAction.checkAlertMessage("Recurring Type is required");
    }


    @Test
    public void checkTransaction(){
        String budget = "Music";
        loginAction.auth();
        addRecurring(budget, 13.0, utils.makeToday("dd/MM/yyyy"), "Daily", "test " + budget + " daily recurring");
        newRecurringsAction.checkSuccessMessage("Successfully created Recurring");
        recurringsAction
                .open()
                .search(budget)
                .checkSearchResult(1)
                .showTransaction()
                .checkTransaction();
    }









    private void addRecurring(String budget, Double amount, String recurringAt, String recurringType, String remark){
        newRecurringsAction
                .open()
                .add(budget, amount, recurringAt, recurringType, remark);
    }


    private void deleteRecurring(String recurring){
        recurringsAction
                .open()
                .search(recurring)
                .delete()
                .checkSearchResult(0);
    }



    @Autowired private LoginAction loginAction;
    @Autowired private RecurringsAction recurringsAction;
    @Autowired private NewRecurringsAction newRecurringsAction;
    @Autowired private Utils utils;
}
