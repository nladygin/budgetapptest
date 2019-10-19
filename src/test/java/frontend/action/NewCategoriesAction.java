package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.CategoriesPage;
import frontend.page.NewCategoriesPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewCategoriesAction extends BaseAction{


    public void open(){
        open(newCategoriesPage.root);
    }


    public void add(String categoryName, Boolean isIncome){
        newCategoriesPage.locatorNameInput.sendKeys(categoryName);
        if (isIncome != null) {
            if (isIncome) {
                newCategoriesPage.locatorIncomeOption.click();
            } else {
                newCategoriesPage.locatorExpenditureOption.click();
            }
        }
        newCategoriesPage.locatorSubmitButton.click();
    }


    public void checkSuccessMessage(String message){
        assertThat(
                newCategoriesPage.locatorSuccessAlert.getText(),
                CoreMatchers.equalTo(message)
        );
    }


    public void checkAlertMessage(String message){
        assertThat(
                newCategoriesPage.locatorAlertMessage.getText(),
                CoreMatchers.equalTo(message)
        );
    }







    @Autowired private NewCategoriesPage newCategoriesPage;
}
