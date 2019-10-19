package frontend;

import frontend.action.LoginAction;
import frontend.action.SignUpAction;
import frontend.config.Credentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SignUpTest extends BaseTest {


    @Test
    public void signUpWithWrongUsername(){
        signUpAction.open();
        signUpAction.signUp("wrongusername", "123456");
        signUpAction.checkAlertMessage("Email is not valid");
    }


    @Test
    public void signUpWithWrongPassword(){
        signUpAction.open();
        signUpAction.signUp("test@test2", "123");
        signUpAction.checkAlertMessage("Password length must be at least 6 characters");
    }


    @Test
    public void signUp(){
        signUpAction.open();
        signUpAction.signUp("test@test3", "123456");
        loginAction.checkSuccessSignUpMessage("Sign Up success. You can Login now.");
    }


    @Test
    public void signUpAlreadyTaken(){
        signUpAction.open();
        signUpAction.signUp(credentials.username, credentials.password);
        signUpAction.checkAlertMessage("Username already taken.");
    }




    @Autowired private SignUpAction signUpAction;
    @Autowired private LoginAction loginAction;
    @Autowired private Credentials credentials;
}
