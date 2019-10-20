package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RecurringsPage extends BasePage{

    public final String root = "/recurrings";

    @FindBy(css = "input.form-control.ng-pristine.ng-valid")            public WebElement locatorSearchInput;
    @FindBy(css = "tbody")                                              public WebElement locatorResultTable;
    @FindBy(css = "tbody > tr:nth-child(1)")                            public WebElement locatorFirstRow;
    @FindBy(css = "tbody > tr:nth-child(1) button.btn.btn-danger")      public WebElement locatorFirstRowDeleteButton;
    @FindBy(css = "div.modal-footer.ng-scope button.btn.btn-danger")    public WebElement locatorConfirmYesButton;
    @FindBy(css = "tbody > tr:nth-child(1) button.btn.btn-primary")     public WebElement locatorFirstRowTransactionButton;
    @FindBy(css = "div.panel-body tbody tr > td:nth-child(1)")          public WebElement locatorRecurringName;
    @FindBy(css = "div.panel-body tbody tr > td:nth-child(2)")          public WebElement locatorRecurringAmount;
    @FindBy(css = "div.panel-body tbody tr > td:nth-child(4)")          public WebElement locatorRecurringRemark;
    @FindBy(css = "div.panel-body tbody tr > td:nth-child(6)")          public WebElement locatorRecurringCreate;
    @FindBy(css = "div.modal-header.ng-scope h3")                       public WebElement locatorTransactionName;
    @FindBy(css = "div.modal-body.ng-scope tbody tr > td:nth-child(1)") public WebElement locatorTransactionAmount;
    @FindBy(css = "div.modal-body.ng-scope tbody tr > td:nth-child(2)") public WebElement locatorTransactionRemark;
    @FindBy(css = "div.modal-body.ng-scope tbody tr > td:nth-child(4)") public WebElement locatorTransactionCreate;





    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
