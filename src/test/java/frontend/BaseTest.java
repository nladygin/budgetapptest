package frontend;

import frontend.config.Config;
import frontend.service.DriverService;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {


    @Before
    public void beforeTest(){
        driverService.initDriver();
    }

    @After
    public void afterTest(){
        driverService.closeDriver();
    }



    @Autowired private DriverService driverService;
}
