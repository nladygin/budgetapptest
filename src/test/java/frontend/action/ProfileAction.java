package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.ProfilePage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class ProfileAction extends BaseAction {

    public void open(){
        open(profilePage.root);
    }

    public void setProfileName(String name){
        pageElementHelper
                .setValue(profilePage.locatorNameInput, name)
                .click(profilePage.locatorUpdateButton);
    }


    public void checkProfileName(String name){
        assertThat(
                profilePage.locatorNameInput.getAttribute("value"),
                CoreMatchers.equalTo(name)
        );
    }


    public void setCurrencySign(String sign){
        pageElementHelper
                .setValue(profilePage.locatorCurrencyInput, sign)
                .click(profilePage.locatorUpdateButton);
    }


    public void checkCurrencySign(String name){
        assertThat(
                profilePage.locatorCurrencyInput.getAttribute("value"),
                CoreMatchers.equalTo(name)
        );
    }








    @Autowired private ProfilePage profilePage;
    @Autowired private PageElementHelper pageElementHelper;
}
