package api;


import api.config.Config;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = { Config.class })
public class BaseTest {




    @BeforeClass
    public static void beforeClass(){

    }

    @Before
    public void beforeTest(){

    }


    @After
    public void afterTest(){

    }


    @AfterClass
    public static void afterClass(){

    }



}
