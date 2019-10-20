package frontend.action;


import frontend.page.NewBudgetsPage;
import frontend.page.NewCategoriesPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewBudgetsAction extends BaseAction{


    public void open(){
        open(newBudgetsPage.root);
    }


    public void add(String budgetName, Boolean isIncome, Double projected){
        if (isIncome != null) {
            Select select = new Select(newBudgetsPage.locatorCategoryOption);
            if (isIncome) {
                select.selectByVisibleText("Income");
            } else {
                select.selectByVisibleText("Home");
            }
        }
        newBudgetsPage.locatorNameInput.sendKeys(budgetName);
        newBudgetsPage.locatorProjectedInput.sendKeys(String.valueOf(projected));
        newBudgetsPage.locatorSubmitButton.click();
    }


    public void checkSuccessMessage(String message){
        assertThat(
                newBudgetsPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
    }


    public void checkAlertMessage(String message){
        assertThat(
                newBudgetsPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
    }







    @Autowired private NewBudgetsPage newBudgetsPage;
}
