package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.CategoriesPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class CategoriesAction extends BaseAction{


    public CategoriesAction open(){
        open(categoriesPage.root);
        return this;
    }


    public CategoriesAction search(String searchString){
        categoriesPage.locatorSearchInput.sendKeys(searchString);
        return this;
    }


    public CategoriesAction checkSearchResult(int resultNumber){
        assertThat(categoriesPage.locatorResultTable.findElements(new By.ByCssSelector("tr")).size(), CoreMatchers.equalTo(resultNumber));
        return this;
    }


    public CategoriesAction delete(){
        pageElementHelper
                .click(categoriesPage.locatorFirstRowDeleteButton)
                .click(categoriesPage.locatorConfirmYesButton);
        return this;
    }









    @Autowired private CategoriesPage categoriesPage;
    @Autowired private PageElementHelper pageElementHelper;
}
