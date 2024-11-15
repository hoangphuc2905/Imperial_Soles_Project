package iuh.imperial_soles_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ImperialSolesProjectApplication {


    public static void main(String[] args) {

        SpringApplication.run(ImperialSolesProjectApplication.class, args);
    }

}
