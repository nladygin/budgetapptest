package frontend.action;


import frontend.page.NewCategoriesPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewCategoriesAction extends BaseAction{


    public NewCategoriesAction open(){
        open(newCategoriesPage.root);
        return this;
    }


    public NewCategoriesAction add(String categoryName, Boolean isIncome){
        newCategoriesPage.locatorNameInput.sendKeys(categoryName);
        if (isIncome != null) {
            if (isIncome) {
                newCategoriesPage.locatorIncomeOption.click();
            } else {
                newCategoriesPage.locatorExpenditureOption.click();
            }
        }
        newCategoriesPage.locatorSubmitButton.click();
        return this;
    }


    public NewCategoriesAction checkSuccessMessage(String message){
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(newCategoriesPage.locatorSuccessAlert));
        assertThat(
                newCategoriesPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }


    public NewCategoriesAction checkAlertMessage(String message){
        assertThat(
                newCategoriesPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
        return this;
    }







    @Autowired private NewCategoriesPage newCategoriesPage;
}
