package com.anymind.bitcoin;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 *
 * @author sonyg
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = BitcoinApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseTestClass {

    @LocalServerPort
    public int port;

    @Autowired
    public TestRestTemplate restTemplate;
}
