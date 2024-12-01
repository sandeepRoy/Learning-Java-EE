package com.example.crudtest1.service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class HelloServiceTest {

    private static final Logger logger = Logger.getLogger(HelloServiceTest.class.getName());

    @Deployment
    public static WebArchive createDeployment() {

        logger.info("I'm inside createDeployment()");

//        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar")
//                .addClass(StudentService.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//        System.out.println(jar.toString(true));

        WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "crud-test-1-1.0-SNAPSHOT.war")
                .addClass(StudentService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    // Why Inject isn't working here?
    // @Inject
    // HelloService helloService;

    @Test
    public void shouldGreet() {
        logger.info("I'm inside shouldGreet()");
        HelloService helloService = new HelloService();
        String response = helloService.sayHello("Sandeep Roy");
        Assert.assertEquals(response, "Hello! Sandeep Roy");
    }
}