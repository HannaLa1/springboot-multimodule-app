package by.iba.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"by.iba"})
public class SpringbootMultimoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMultimoduleApplication.class, args);
    }

}
