package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class NewBudgetsPage extends BasePage{

    public final String root = "/budgets/new";

    @FindBy(id = "categoryId")                                      public WebElement locatorCategoryOption;
    @FindBy(id = "name")                                            public WebElement locatorNameInput;
    @FindBy(id = "projected")                                       public WebElement locatorProjectedInput;
    @FindBy(css = "button.btn.btn-primary")                         public WebElement locatorSubmitButton;
    @FindBy(css = "div.alert.alert-success.ng-binding.ng-scope")    public WebElement locatorSuccessAlert;
    @FindBy(css = "div.form-group.has-feedback.has-error span")     public WebElement locatorAlertMessage;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
