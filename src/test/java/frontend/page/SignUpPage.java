package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class SignUpPage extends BasePage{

    public final String root = "/signup";

    @FindBy(id = "username")                                        public WebElement locatorUsernameInput;
    @FindBy(id = "password")                                        public WebElement locatorPasswordInput;
    @FindBy(css = "form > button")                                  public WebElement locatorSignUpButton;
    @FindBy(css = "div.form-group.has-feedback.has-error > span")   public WebElement locatorAlertMessage;


    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }

}
