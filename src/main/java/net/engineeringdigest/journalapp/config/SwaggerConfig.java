package net.engineeringdigest.journalapp.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Journal App APIs")
                        .version("v1.0.0")
                        .description("This documentation provides details about the Journal App RESTful APIs. It allows developers to understand and interact with the available endpoints.")
                        .termsOfService("http://swagger.io/terms/") // Example terms of service URL
                        .contact(new Contact()
                                .name("Engineering Digest")
                                .url("https://www.engineeringdigest.net"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .tags(Arrays.asList(
                        new Tag().name("Public APIs"),
                        new Tag().name("User APIs"),
                        new Tag().name("Journal APIs"),
                        new Tag().name("Admin APIs")
                ));
    }
}
