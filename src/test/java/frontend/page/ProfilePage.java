package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class ProfilePage extends BasePage{

    public final String root = "/profile";

    @FindBy(id = "name")            public WebElement locatorNameInput;
    @FindBy(id = "currency")        public WebElement locatorCurrencyInput;
    @FindBy(css = "form button")  public WebElement locatorUpdateButton;


    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }


}
