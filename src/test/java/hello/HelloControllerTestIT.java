package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by amit on 9/17/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTestIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() throws MalformedURLException {
        base = new URL("http://localhost:" + port + "/hello/amit/");

        System.out.println("Test URL : " + "http://localhost:" + port + "/hello/amit/");
    }

    @Test
    public void shouldTestMessage(){
        ResponseEntity<String> entity = restTemplate.getForEntity(base.toString(), String.class);
        assertThat(entity.getBody(), is("Greeting from Amit for Spring Boot"));
    }
}
