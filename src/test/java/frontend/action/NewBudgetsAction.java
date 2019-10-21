package frontend.action;


import frontend.page.NewBudgetsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewBudgetsAction extends BaseAction{


    public NewBudgetsAction open(){
        open(newBudgetsPage.root);
        return this;
    }


    public NewBudgetsAction add(String budgetName, Boolean isIncome, Double projected){
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
        return this;
    }


    public NewBudgetsAction checkSuccessMessage(String message){
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(newBudgetsPage.locatorSuccessAlert));
        assertThat(
                newBudgetsPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }


    public NewBudgetsAction checkAlertMessage(String message){
        assertThat(
                newBudgetsPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }







    @Autowired private NewBudgetsPage newBudgetsPage;
}
