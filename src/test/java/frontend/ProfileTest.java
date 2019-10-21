package frontend;

import frontend.action.LoginAction;
import frontend.action.ProfileAction;
import frontend.config.Credentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {


    @Test
    public void changeUserName(){
        String profileName = "Slim Shady";
        loginAction.auth();
        profileAction
                .open()
                .setProfileName(profileName)
                .checkProfileName(profileName)
                .checkSuccessMessage("Successfully update profile");
    }


    @Test
    public void changeCurrencySign(){
        String currencySign = "RUR";
        loginAction.auth();
        profileAction
                .open()
                .setCurrencySign(currencySign)
                .checkCurrencySign(currencySign)
                .checkSuccessMessage("Successfully update profile");
    }


    @Test
    public void changePassword(){
        loginAction.auth();
        profileAction
                .open()
                .gotoPassword()
                .changeProfilePassword(credentials.password, credentials.password, credentials.password)
                .checkSuccessMessage("Successfully change password");
    }


    @Test
    public void changePasswordWithBadOne(){
        loginAction.auth();
        profileAction
                .open()
                .gotoPassword()
                .changeProfilePassword(credentials.password, "123", "123")
                .checkAlertMessage("Password length must be at least 6 characters");
    }


    @Test
    public void changePasswordWithBadConfirm(){
        loginAction.auth();
        profileAction
                .open()
                .gotoPassword()
                .changeProfilePassword(credentials.password, "123456", "123")
                .checkAlertMessage("Confirm Password does not match");
    }






    @Autowired private LoginAction loginAction;
    @Autowired private ProfileAction profileAction;
    @Autowired private Credentials credentials;
}
