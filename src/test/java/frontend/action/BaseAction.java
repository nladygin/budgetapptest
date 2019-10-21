package frontend.action;

import frontend.config.Config;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseAction {



    protected void open(String pageURN){
        String port = "8181";
        if (System.getProperty("port") != null) {
            port = System.getProperty("port");
        }
        driver.get(config.serverUrl + ":" + port + pageURN);
    }



    @Autowired protected WebDriver driver;
    @Autowired private Config config;
}
