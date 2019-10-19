package frontend;

import frontend.action.LoginAction;
import frontend.action.ProfileAction;
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
        profileAction.open();
        profileAction.setProfileName(profileName);
        profileAction.checkProfileName(profileName);
    }


    @Test
    public void changeCurrencySign(){
        String currencySign = "RUR";
        loginAction.auth();
        profileAction.open();
        profileAction.setCurrencySign(currencySign);
        profileAction.checkCurrencySign(currencySign);
    }




    @Autowired private LoginAction loginAction;
    @Autowired private ProfileAction profileAction;
}
