package by.andervyd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("by.andervyd")
public class Config {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
