package frontend.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DashboardPage extends BasePage{

    public final String root = "/dashboard";

    @FindBy(css = "section.content-header.ng-scope")          public WebElement locatorHeader;
    @FindBy(css = "div.small-box.bg-aqua h3:nth-child(2)")    public WebElement locatorIncome;
    @FindBy(css = "div.small-box.bg-yellow h3:nth-child(2)")  public WebElement locatorProjected;
    @FindBy(css = "div.small-box.bg-red h3:nth-child(2)")     public WebElement locatorActual;
    @FindBy(css = "div.small-box.bg-green h3:nth-child(2)")   public WebElement locatorRemaining;



    @PostConstruct
    private void initPage(){
        PageFactory.initElements(driver, this);
    }

}
