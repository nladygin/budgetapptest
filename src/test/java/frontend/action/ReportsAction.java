package frontend.action;


import frontend.page.ReportsPage;
import frontend.page.SignUpPage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class ReportsAction extends BaseAction{


    public ReportsAction open(){
        open(reportsPage.root);
        return this;
    }


    public ReportsAction setFilter(Double min, Double max, String from, String till){
        reportsPage.locatorMinAmountInput.sendKeys(String.valueOf(min));
        reportsPage.locatorMaxAmountInput.sendKeys(String.valueOf(max));
        reportsPage.locatorStartOnInput.sendKeys(from);
        reportsPage.locatorEndOnInput.sendKeys(till);
        reportsPage.locatorSearchButton.click();
        return this;
    }


    public int getResultNumber(){
        return reportsPage.locatorResult.size();
    }


    public ReportsAction checkResult(int expected, int real){
        assertThat(expected, CoreMatchers.equalTo(real));
        return this;
    }









    @Autowired private ReportsPage reportsPage;
}
