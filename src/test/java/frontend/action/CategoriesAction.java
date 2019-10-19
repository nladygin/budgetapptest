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
public class CategoriesAction extends BaseAction{


    public void open(){
        open(categoriesPage.root);
    }


    public void search(String searchString){
        categoriesPage.locatorSearchInput.sendKeys(searchString);
    }


    public void checkSearchResult(int resultNumber){
        assertThat(categoriesPage.locatorResultTable.findElements(new By.ByCssSelector("tr")).size(), CoreMatchers.equalTo(resultNumber));
    }


    public void delete(){
        pageElementHelper
                .click(categoriesPage.locatorFirstRowDeleteButton)
                .click(categoriesPage.locatorConfirmYesButton);
    }









    @Autowired private CategoriesPage categoriesPage;
    @Autowired private PageElementHelper pageElementHelper;
}
