package frontend.action;


import frontend.page.SignUpPage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class SignUpAction extends BaseAction{


    public void open(){
        open(signUpPage.root);
    }


    public void signUp(String username, String password){
        signUpPage.locatorUsernameInput.sendKeys(username);
        signUpPage.locatorPasswordInput.sendKeys(password);
        signUpPage.locatorSignUpButton.click();
    }


    public void checkAlertMessage(String message){
        assertThat(signUpPage.locatorAlertMessage.getText(), CoreMatchers.equalTo(message));
    }









    @Autowired private SignUpPage signUpPage;
}
