package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class CategoriesPage extends BasePage{

    public final String root = "/categories";

    @FindBy(css = "input.form-control.ng-pristine.ng-valid")            public WebElement locatorSearchInput;
    @FindBy(css = "tbody")                                              public WebElement locatorResultTable;
    @FindBy(css = "tbody > tr:nth-child(1)")                            public WebElement locatorFirstRow;
    @FindBy(css = "tbody > tr:nth-child(1) button")                     public WebElement locatorFirstRowDeleteButton;
    @FindBy(css = "div.modal-footer.ng-scope button.btn.btn-danger")    public WebElement locatorConfirmYesButton;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
