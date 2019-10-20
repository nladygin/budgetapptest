package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.BudgetsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class BudgetsAction extends BaseAction{


    public void open(){
        open(budgetsPage.root);
    }


    public void search(String searchString){
        budgetsPage.locatorSearchInput.sendKeys(searchString);
    }


    public void checkSearchResult(int resultNumber){
        assertThat(budgetsPage.locatorResultTable.findElements(new By.ByCssSelector("tr")).size(), CoreMatchers.equalTo(resultNumber));
    }


    public void delete(){
        pageElementHelper
                .click(budgetsPage.locatorFirstRowDeleteButton)
                .click(budgetsPage.locatorConfirmYesButton);
    }









    @Autowired private BudgetsPage budgetsPage;
    @Autowired private PageElementHelper pageElementHelper;
}
