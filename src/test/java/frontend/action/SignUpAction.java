package frontend.action;


import frontend.page.SignUpPage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class SignUpAction extends BaseAction{


    public SignUpAction open(){
        open(signUpPage.root);
        return this;
    }


    public SignUpAction signUp(String username, String password){
        signUpPage.locatorUsernameInput.sendKeys(username);
        signUpPage.locatorPasswordInput.sendKeys(password);
        signUpPage.locatorSignUpButton.click();
        return this;
    }


    public SignUpAction checkAlertMessage(String message){
        assertThat(signUpPage.locatorAlertMessage.getText(), CoreMatchers.equalTo(message));
        return this;
    }









    @Autowired private SignUpPage signUpPage;
}
