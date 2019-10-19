package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class LoginPage extends BasePage{

    public final String root = "/";

    @FindBy(id = "username")                                        public WebElement locatorUsernameInput;
    @FindBy(id = "password")                                        public WebElement locatorPasswordInput;
    @FindBy(css = "form > button")                                  public WebElement locatorLoginButton;
    @FindBy(css = "div.alert.alert-danger.ng-scope li")             public WebElement locatorAlertMessage;
    @FindBy(css = "div.alert.alert-success.ng-binding.ng-scope")    public WebElement locatorSuccessSignUpMessage;


    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }

}
