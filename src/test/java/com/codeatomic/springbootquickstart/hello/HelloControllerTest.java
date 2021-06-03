package com.codeatomic.springbootquickstart.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloControllerTest
{
    @InjectMocks
    HelloController helloController;

    @Test
    public void hellowWorldTest()
    {
        assertEquals("Hello World!",helloController.hellowWorld());
    }
}
