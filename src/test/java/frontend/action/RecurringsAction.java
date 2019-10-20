package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.RecurringsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class RecurringsAction extends BaseAction{


    public void open(){
        open(recurringsPage.root);
    }


    public void search(String searchString){
        recurringsPage.locatorSearchInput.sendKeys(searchString);
    }


    public void checkSearchResult(int resultNumber){
        assertThat(recurringsPage.locatorResultTable.findElements(new By.ByCssSelector("tr")).size(), CoreMatchers.equalTo(resultNumber));
    }


    public void delete(){
        pageElementHelper
                .click(recurringsPage.locatorFirstRowDeleteButton)
                .click(recurringsPage.locatorConfirmYesButton);
    }

    public void showTransaction(){
        pageElementHelper
                .click(recurringsPage.locatorFirstRowTransactionButton);
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(recurringsPage.locatorTransactionName));
    }


    public void checkTransaction(){
        assertThat(
                "Transactions: " + recurringsPage.locatorRecurringName.getText(),
                CoreMatchers.equalTo(recurringsPage.locatorTransactionName.getText())
        );
        assertThat(
                recurringsPage.locatorRecurringAmount.getText(),
                CoreMatchers.equalTo(recurringsPage.locatorTransactionAmount.getText())
        );
        assertThat(
                recurringsPage.locatorRecurringRemark.getText(),
                CoreMatchers.equalTo(recurringsPage.locatorTransactionRemark.getText())
        );
        assertThat(
                recurringsPage.locatorRecurringCreate.getText(),
                CoreMatchers.equalTo(recurringsPage.locatorTransactionCreate.getText())
        );
    }









    @Autowired private RecurringsPage recurringsPage;
    @Autowired private PageElementHelper pageElementHelper;
}
