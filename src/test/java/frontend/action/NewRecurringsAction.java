package frontend.action;


import frontend.page.NewRecurringsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewRecurringsAction extends BaseAction{


    public NewRecurringsAction open(){
        open(newRecurringsPage.root);
        return this;
    }


    public NewRecurringsAction add(String budget, Double amount, String recurringAt, String recurringType, String remark){
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
        return this;
    }


    public NewRecurringsAction checkSuccessMessage(String message){
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(newRecurringsPage.locatorSuccessAlert));
        assertThat(
                newRecurringsPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }


    public NewRecurringsAction checkAlertMessage(String message){
        assertThat(
                newRecurringsPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }







    @Autowired private NewRecurringsPage newRecurringsPage;
}
