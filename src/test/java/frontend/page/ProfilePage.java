package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class ProfilePage extends BasePage{

    public final String root = "/profile";

    @FindBy(id = "name")                                            public WebElement locatorNameInput;
    @FindBy(id = "currency")                                        public WebElement locatorCurrencyInput;
    @FindBy(css = "form:nth-child(1) button")                       public WebElement locatorUpdateButton;
    @FindBy(css = "ul.nav.nav-tabs li:nth-child(2)")                public WebElement locatorPasswordTab;
    @FindBy(id = "original")                                        public WebElement locatorOriginalPasswordInput;
    @FindBy(id = "password")                                        public WebElement locatorNewPasswordInput;
    @FindBy(id = "confirm")                                         public WebElement locatorConfirmPasswordInput;
    @FindBy(css = "div.alert.alert-success.ng-binding.ng-scope")    public WebElement locatorSuccessMessage;
    @FindBy(css = "form:nth-child(2) button")                       public WebElement locatorChangePasswordButton;
    @FindBy(css = "div.form-group.has-feedback.has-error span")   public WebElement locatorAlertMessage;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
