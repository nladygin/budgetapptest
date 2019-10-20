package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DashboardPage extends BasePage{

    public final String root = "/dashboard";

    @FindBy(css = "section.content-header.ng-scope") public WebElement locatorHeader;


    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }

}
