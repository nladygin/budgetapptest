package frontend.config;

import frontend.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("frontend")
@PropertySource({"config.properties"})
//@DirtiesContext
public class Config {


//    @Bean
//    public WebDriver getDriver() {
//        return driverService.initDriver();
//    }



    @Value("${server_url}") public String serverUrl;
    @Autowired private DriverService driverService;
}
