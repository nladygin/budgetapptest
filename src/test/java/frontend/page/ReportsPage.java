package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class ReportsPage extends BasePage{

    public final String root = "/reports";

    @FindBy(id = "minAmount")               public WebElement locatorMinAmountInput;
    @FindBy(id = "maxAmount")               public WebElement locatorMaxAmountInput;
    @FindBy(id = "startOn")                 public WebElement locatorStartOnInput;
    @FindBy(id = "endOn")                   public WebElement locatorEndOnInput;
    @FindBy(css = "button.btn.btn-primary") public WebElement locatorSearchButton;
    @FindBy(css = "tbody tr")               public List<WebElement> locatorResult;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
