package frontend.config;

import frontend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("frontend")
@PropertySource({"config.properties"})
public class Config {

    @Value("${server_url}") public String serverUrl;
    @Autowired private DriverService driverService;
}
