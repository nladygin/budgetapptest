package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.ImportPage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class ImportAction extends BaseAction{


    public ImportAction open(){
        open(importPage.root);
        return this;
    }


    public ImportAction selectFile(){
        File file = new File(getClass().getClassLoader().getResource("import.csv").getFile());
        importPage.locatorFileInput.sendKeys(file.getAbsolutePath());
        return this;
    }


    public ImportAction setColumnType(){
        pageElementHelper.setSelectorValue(importPage.locatorTypeSelectors.get(0), "Amount");
        pageElementHelper.setSelectorValue(importPage.locatorTypeSelectors.get(1), "Transaction Date");
        pageElementHelper.setSelectorValue(importPage.locatorTypeSelectors.get(2), "Remark");
        pageElementHelper.setSelectorValue(importPage.locatorTypeSelectors.get(3), "None of the Above");
        importPage.locatorConfirmButton.click();
        return this;
    }


    public ImportAction deleteRecord(int index){
        importPage.locatorRemoveButtons.get(index).click();
        return this;
    }


    public ImportAction setBudget(int index, String category, String budget){
        importPage.locatorBudgetSelectors.get(index).click();
        pageElementHelper.setSelectorValue(importPage.locatorCategorySelector, category);
        pageElementHelper.setSelectorValue(importPage.locatorBudgetSelector, budget);
        importPage.locatorModalConfirmButton.click();
        return this;
    }


    public ImportAction submitData(){
        pageElementHelper.click(importPage.locatorSubmitButton);
        return this;
    }


    public ImportAction checkResult(String message){
        assertThat(importPage.locatorSuccessMassage.getText(), CoreMatchers.equalTo(message));
        return this;
    }








    @Autowired private ImportPage importPage;
    @Autowired private PageElementHelper pageElementHelper;
}
