package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 9/17/2016.
 */
@RestController
public class HelloController {

    @Value("${greeting}")
    String greetings;

    @RequestMapping("/hello/amit")
    public String index(){
        return "Greeting from Amit for Spring Boot";
    }

    @RequestMapping("/hello/greetings")
    public String hello(){
        return String.format("Hello ... %s", greetings);
    }
}
