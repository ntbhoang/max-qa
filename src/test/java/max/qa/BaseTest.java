package max.qa;

import max.qa.driver.Driver;

import org.testng.annotations.*;

import java.io.IOException;


public class BaseTest {

    protected BaseTest(){}

    @BeforeTest
    protected void setUp(){
        Driver.initDriver();
    }


    @AfterTest
    protected void tearDown() throws IOException {
        Driver.quitDriver();
    }
}
