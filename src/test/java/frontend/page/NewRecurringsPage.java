package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class NewRecurringsPage extends BasePage{

    public final String root = "/recurrings/new";

    @FindBy(id = "budgetId")                                        public WebElement locatorBudgetOption;
    @FindBy(id = "amount")                                          public WebElement locatorAmountInput;
    @FindBy(id = "recurringAt")                                     public WebElement locatorRecurringAtInput;
    @FindBy(id = "recurringType")                                   public WebElement locatorRecurringTypeOption;
    @FindBy(id = "remark")                                          public WebElement locatorRemarkInput;
    @FindBy(css = "button.btn.btn-primary")                         public WebElement locatorSubmitButton;
    @FindBy(css = "div.alert.alert-success.ng-binding.ng-scope")    public WebElement locatorSuccessAlert;
    @FindBy(css = "div.form-group.has-feedback.has-error span")     public WebElement locatorAlertMessage;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
