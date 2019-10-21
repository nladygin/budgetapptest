package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.helper.Utils;
import frontend.page.BudgetsPage;
import frontend.page.DashboardPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class DashboardAction extends BaseAction{


    public DashboardAction open(){
        open(dashboardPage.root);
        new WebDriverWait(driver, 4L).until(ExpectedConditions.textMatches(By.cssSelector("div.small-box.bg-aqua h3:nth-child(2)"), Pattern.compile(".+")));
        return this;
    }


    public Double getIncome(){
        return utils.cleanValue(dashboardPage.locatorIncome.getText());
    }

    public Double getProjected(){
        return utils.cleanValue(dashboardPage.locatorProjected.getText());
    }

    public Double getActual(){
        return utils.cleanValue(dashboardPage.locatorActual.getText());
    }

    public Double getRemaining(){
        return utils.cleanValue(dashboardPage.locatorRemaining.getText());
    }

    public DashboardAction checkValue(Double before, Double current){
        assertThat(before, CoreMatchers.equalTo(current));
        return this;
    }











    @Autowired private DashboardPage dashboardPage;
    @Autowired private Utils utils;
    @Autowired private PageElementHelper pageElementHelper;
}
