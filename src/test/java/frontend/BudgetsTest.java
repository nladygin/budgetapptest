package frontend;

import frontend.action.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BudgetsTest extends BaseTest {


    @Test
    public void searchBudget(){
        loginAction.auth();
        budgetsAction.open();
        budgetsAction.search("divi");
        budgetsAction.checkSearchResult(1);
    }


    @Test
    public void searchNonexistentBudget(){
        loginAction.auth();
        budgetsAction.open();
        budgetsAction.search("nonexistentbudget");
        budgetsAction.checkSearchResult(0);
    }


    @Test
    public void addIncomeBudget(){
        String category = "test income budget";
        loginAction.auth();
        addBudget(category, true, 13.0);
        newBudgetsAction.checkSuccessMessage("Successfully created Budget");
    }


    @Test
    public void addHomeBudget(){
        String category = "test home budget";
        loginAction.auth();
        addBudget(category, false, 13.0);
        newBudgetsAction.checkSuccessMessage("Successfully created Budget");
    }


    @Test
    public void deleteBudget(){
        String category = "test budget for delete";
        loginAction.auth();
        addBudget(category, true, 13.0);
        deleteBudget(category);
    }


    @Test
    public void addBudgetWithEmptyName(){
        loginAction.auth();
        addBudget("",true,13.0);
        newBudgetsAction.checkAlertMessage("Name is required");
    }


    @Test
    public void addBudgetWithEmptyCategory(){
        loginAction.auth();
        addBudget("budget with empty category",null, 13.0);
        newBudgetsAction.checkAlertMessage("Category is required");
    }


    @Test
    public void addBudgetWithEmptyProjected(){
        loginAction.auth();
        addBudget("budget with empty projected",true, 0.0);
        newBudgetsAction.checkSuccessMessage("Successfully created Budget");
    }







    private void addBudget(String budget, Boolean isIncome, Double projected){
        newBudgetsAction.open();
        newBudgetsAction.add(budget, isIncome, projected);
    }


    private void deleteBudget(String budget){
        budgetsAction.open();
        budgetsAction.search(budget);
        budgetsAction.delete();
        budgetsAction.checkSearchResult(0);
    }



    @Autowired private LoginAction loginAction;
    @Autowired private BudgetsAction budgetsAction;
    @Autowired private NewBudgetsAction newBudgetsAction;
}
