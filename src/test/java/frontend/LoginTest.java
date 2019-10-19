package frontend;

import frontend.action.LoginAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginTest extends BaseTest {


    @Test
    public void loginWithWrongUsername(){
        loginAction.open();
        loginAction.login("wrongusername", "123456");
        loginAction.checkAlertMessage("Invalid username and password combination");
    }


    @Test
    public void loginWithWrongPassword(){
        loginAction.open();
        loginAction.login("test@test", "wrongpassword");
        loginAction.checkAlertMessage("Invalid username and password combination");
    }






    @Autowired private LoginAction loginAction;
}
