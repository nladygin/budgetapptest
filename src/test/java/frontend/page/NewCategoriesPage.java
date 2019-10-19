package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class NewCategoriesPage extends BasePage{

    public final String root = "/categories/new";

    @FindBy(id = "name")                                            public WebElement locatorNameInput;
    @FindBy(css = "input[value~=\"INCOME\"]")                       public WebElement locatorIncomeOption;
    @FindBy(css = "input[value~=\"EXPENDITURE\"]")                  public WebElement locatorExpenditureOption;
    @FindBy(css = "button.btn.btn-primary")                         public WebElement locatorSubmitButton;
    @FindBy(css = "div.alert.alert-success.ng-binding.ng-scope")    public WebElement locatorSuccessAlert;
    @FindBy(css = "div.form-group.has-feedback.has-error span")     public WebElement locatorAlertMessage;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
