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

    public void gotoPassword(){
        profilePage.locatorPasswordTab.click();
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


    public void changeProfilePassword(String originalPassword, String newPassword, String confirmPassword){
        profilePage.locatorOriginalPasswordInput.sendKeys(originalPassword);
        profilePage.locatorNewPasswordInput.sendKeys(newPassword);
        profilePage.locatorConfirmPasswordInput.sendKeys(confirmPassword);
        profilePage.locatorChangePasswordButton.click();
    }


    public void checkSuccessMessage(String message){
        assertThat(profilePage.locatorSuccessMessage.getText(), CoreMatchers.equalTo(message));
    }

    public void checkAlertMessage(String message){
        assertThat(profilePage.locatorAlertMessage.getText(), CoreMatchers.equalTo(message));
    }






    @Autowired private ProfilePage profilePage;
    @Autowired private PageElementHelper pageElementHelper;
}
