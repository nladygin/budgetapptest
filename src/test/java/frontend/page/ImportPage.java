package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class ImportPage extends BasePage{

    public final String root = "/import";

    @FindBy(id = "minAmount")                                                           public WebElement locatorFileInput;
    @FindBy(css = "button.btn.btn-success.btn-block")                                   public WebElement locatorConfirmButton;
    @FindBy(css = "thead select")                                                       public List<WebElement> locatorTypeSelectors;
    @FindBy(css = "tbody tr td:nth-child(4) span")                                      public List<WebElement> locatorBudgetSelectors;
    @FindBy(id = "category")                                                            public WebElement locatorCategorySelector;
    @FindBy(css = "div.modal-dialog div.form-group.row.ng-scope:nth-child(2) select")   public WebElement locatorBudgetSelector;
    @FindBy(css = "div.modal-dialog button.btn.btn-success")                            public WebElement locatorModalConfirmButton;
    @FindBy(css = "button.btn.btn-danger")                                              public List<WebElement> locatorRemoveButtons;
    @FindBy(how= How.XPATH, using="//button[text()='Submit All']")                      public WebElement locatorSubmitButton;
    @FindBy(css = "section.content.ng-scope h3.panel-title")                            public WebElement locatorSuccessMassage;





    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
