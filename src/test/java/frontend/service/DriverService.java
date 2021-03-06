package frontend.service;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class DriverService {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;


    @Bean
    public WebDriver initDriver(){
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(13L, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(4L, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }


    public void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
