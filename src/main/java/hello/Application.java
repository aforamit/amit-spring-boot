package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by amit on 9/17/2016.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("Beans initialized by Spring Boot");

        String[] beans = context.getBeanDefinitionNames();
        Arrays.stream(beans).sorted().forEach(System.out::println);

    }
}
