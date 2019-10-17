package api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan()
@PropertySource({"config.properties"})
public class Config {

    @Value("${server_url}")
    public String serverURL;


}
