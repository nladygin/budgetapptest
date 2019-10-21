package frontend.action;


import frontend.helper.PageElementHelper;
import frontend.page.ProfilePage;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class ProfileAction extends BaseAction {

    public ProfileAction open(){
        open(profilePage.root);
        return this;
    }

    public ProfileAction gotoPassword(){
        profilePage.locatorPasswordTab.click();
        return this;
    }

    public ProfileAction setProfileName(String name){
        pageElementHelper
                .setValue(profilePage.locatorNameInput, name)
                .click(profilePage.locatorFormButton);
        return this;
    }


    public ProfileAction checkProfileName(String name){
        assertThat(
                profilePage.locatorNameInput.getAttribute("value"),
                CoreMatchers.equalTo(name)
        );
        return this;
    }


    public ProfileAction setCurrencySign(String sign){
        pageElementHelper
                .setValue(profilePage.locatorCurrencyInput, sign)
                .click(profilePage.locatorFormButton);
        return this;
    }


    public ProfileAction checkCurrencySign(String name){
        assertThat(
                profilePage.locatorCurrencyInput.getAttribute("value"),
                CoreMatchers.equalTo(name)
        );
        return this;
    }


    public ProfileAction changeProfilePassword(String originalPassword, String newPassword, String confirmPassword){
        profilePage.locatorOriginalPasswordInput.sendKeys(originalPassword);
        profilePage.locatorNewPasswordInput.sendKeys(newPassword);
        profilePage.locatorConfirmPasswordInput.sendKeys(confirmPassword);
        profilePage.locatorFormButton.click();
        return this;
    }


    public ProfileAction checkSuccessMessage(String message){
        assertThat(profilePage.locatorSuccessMessage.getText(), CoreMatchers.equalTo(message));
        return this;
    }

    public ProfileAction checkAlertMessage(String message){
        assertThat(profilePage.locatorAlertMessage.getText(), CoreMatchers.equalTo(message));
        return this;
    }






    @Autowired private ProfilePage profilePage;
    @Autowired private PageElementHelper pageElementHelper;
}
