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


    public RecurringsAction open(){
        open(recurringsPage.root);
        return this;
    }


    public RecurringsAction search(String searchString){
        recurringsPage.locatorSearchInput.sendKeys(searchString);
        return this;
    }


    public RecurringsAction checkSearchResult(int resultNumber){
        assertThat(recurringsPage.locatorResultTable.findElements(new By.ByCssSelector("tr")).size(), CoreMatchers.equalTo(resultNumber));
        return this;
    }


    public RecurringsAction delete(){
        pageElementHelper
                .click(recurringsPage.locatorFirstRowDeleteButton)
                .click(recurringsPage.locatorConfirmYesButton);
        return this;
    }

    public RecurringsAction showTransaction(){
        pageElementHelper
                .click(recurringsPage.locatorFirstRowTransactionButton);
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(recurringsPage.locatorTransactionName));
        return this;
    }


    public RecurringsAction checkTransaction(){
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
        return this;
    }









    @Autowired private RecurringsPage recurringsPage;
    @Autowired private PageElementHelper pageElementHelper;
}
