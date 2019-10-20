package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.RecurringsPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
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









    @Autowired private RecurringsPage recurringsPage;
    @Autowired private PageElementHelper pageElementHelper;
}
