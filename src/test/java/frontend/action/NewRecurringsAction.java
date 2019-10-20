package frontend.action;


import frontend.page.NewCategoriesPage;
import frontend.page.NewRecurringsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewRecurringsAction extends BaseAction{


    public void open(){
        open(newRecurringsPage.root);
    }


    public void add(String budget, Double amount, String recurringAt, String recurringType, String remark){
        Select budgetSelect = new Select(newRecurringsPage.locatorBudgetOption);
        if (budget != "") {
            budgetSelect.selectByVisibleText(budget);
        }
        newRecurringsPage.locatorAmountInput.sendKeys(String.valueOf(amount));
        newRecurringsPage.locatorRecurringAtInput.sendKeys((recurringAt != null) ? recurringAt:"");
        Select recurringTypeSelect = new Select(newRecurringsPage.locatorRecurringTypeOption);
        if (recurringType != "") {
            recurringTypeSelect.selectByVisibleText(recurringType);
        }
        newRecurringsPage.locatorRemarkInput.sendKeys((remark != null) ? remark:"");
        newRecurringsPage.locatorSubmitButton.click();
    }


    public void checkSuccessMessage(String message){
        assertThat(
                newRecurringsPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
    }


    public void checkAlertMessage(String message){
        assertThat(
                newRecurringsPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
    }







    @Autowired private NewRecurringsPage newRecurringsPage;
}