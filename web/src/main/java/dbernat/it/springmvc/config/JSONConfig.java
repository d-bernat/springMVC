package dbernat.it.springmvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JSONConfig
{

    //überschreibt  die spring.jackson - Einstellungen in application.yaml
    @Bean
    public ObjectMapper configureJson()
    {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
                .build();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeJson()
    {
        return builder ->
        {
            builder.indentOutput(false);
            builder.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        };
    }

}
