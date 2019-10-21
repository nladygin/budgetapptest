package frontend;

import frontend.action.CategoriesAction;
import frontend.action.LoginAction;
import frontend.action.NewCategoriesAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoriesTest extends BaseTest {


    @Test
    public void searchCategory(){
        loginAction.auth();
        categoriesAction
                .open()
                .search("home")
                .checkSearchResult(1);
    }


    @Test
    public void searchNonexistentCategory(){
        loginAction.auth();
        categoriesAction
                .open()
                .search("nonexistentcategory")
                .checkSearchResult(0);
    }


    @Test
    public void addIncomeCategory(){
        String category = "test income category";
        addCategory(category, true);
        newCategoriesAction.checkSuccessMessage("Successfully created Category");
    }


    @Test
    public void addExpenditureCategory(){
        String category = "test expenditure category";
        addCategory(category, false);
        newCategoriesAction.checkSuccessMessage("Successfully created Category");
    }


    @Test
    public void deleteCategory(){
        String category = "test category for delete";
        addCategory(category, true);
        deleteCategory(category);
    }


    @Test
    public void addCategoryWithEmptyName(){
        addCategory("",true);
        newCategoriesAction.checkAlertMessage("Name is required");
    }


    @Test
    public void addCategoryWithEmptyType(){
        addCategory("category with empty type",null);
        newCategoriesAction.checkAlertMessage("Category Type is required");
    }








    private void addCategory(String category, Boolean isIncome){
        loginAction.auth();
        newCategoriesAction
                .open()
                .add(category, isIncome);
    }


    private void deleteCategory(String category){
        categoriesAction
                .open()
                .search(category)
                .delete()
                .checkSearchResult(0);

    }



    @Autowired private LoginAction loginAction;
    @Autowired private CategoriesAction categoriesAction;
    @Autowired private NewCategoriesAction newCategoriesAction;
}
