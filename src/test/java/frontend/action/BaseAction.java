package frontend.action;

import frontend.config.Config;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseAction {



    protected void open(String pageURN){
        driver.get(config.serverUrl + pageURN);
    }



    @Autowired private WebDriver driver;
    @Autowired private Config config;
}
