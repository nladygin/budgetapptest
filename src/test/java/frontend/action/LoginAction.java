package frontend.action;


import frontend.config.Credentials;
import frontend.helper.Utils;
import frontend.page.DashboardPage;
import frontend.page.LoginPage;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class LoginAction extends BaseAction{

    private WebDriverWait wait;


    public void open(){
        open(loginPage.root);
    }


    public void auth(){
        open();
        login(credentials.username, credentials.password);
//        utils.setCookie("auth", utils.makeAuthToken(credentials.username, credentials.password));
    }


    public void login(String username, String password){
        loginPage.locatorUsernameInput.sendKeys(username);
        loginPage.locatorPasswordInput.sendKeys(password);
        loginPage.locatorLoginButton.click();
        new WebDriverWait(driver, 4L).until(ExpectedConditions.visibilityOf(dashboardPage.locatorHeader));
    }


    public void checkAlertMessage(String message){
        assertThat(loginPage.locatorAlertMessage.getText(), CoreMatchers.equalTo(message));
    }


    public void checkSuccessSignUpMessage(String message){
        assertThat(loginPage.locatorSuccessSignUpMessage.getText(), CoreMatchers.equalTo(message));
    }







    //    @Autowired private Utils utils;
    @Autowired private Credentials credentials;
    @Autowired private LoginPage loginPage;
    @Autowired private DashboardPage dashboardPage;
}
