package app.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ImportResource({"classpath:spring/*-context.xml"})
@ComponentScan(basePackages={"app"})
@EnableAutoConfiguration
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
