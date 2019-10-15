package api;


import api.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.jws.soap.SOAPBinding;


@ContextConfiguration(classes = { Config.class })
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//@TestExecutionListeners({DirtiesContextTestExecutionListener.class})
public class BaseTest {

//    protected User user;



    @BeforeClass
    public static void beforeClass(){

    }

    @Before
    public void beforeTest(){
//        authHelper.authorization();
//        user = authHelper.authorization();
    }


    @After
    public void afterTest(){

    }


    @AfterClass
    public static void afterClass(){

    }



    @Autowired private AuthHelper authHelper;
}
