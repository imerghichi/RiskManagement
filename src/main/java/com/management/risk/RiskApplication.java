package com.management.risk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Risk application.
 */
@SpringBootApplication
@EnableSwagger2
public class RiskApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


		SpringApplication.run(RiskApplication.class, args);
	}

}
