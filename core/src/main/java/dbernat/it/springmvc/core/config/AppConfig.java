package dbernat.it.springmvc.core.config;

import dbernat.it.springmvc.core.qualifiers.GuessCount;
import dbernat.it.springmvc.core.qualifiers.MaxNumber;
import dbernat.it.springmvc.core.qualifiers.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "core.game")
@ComponentScan(basePackages = "dbernat.it.springmvc")
public class AppConfig
{
    @Value("100")
    private int maxNumber;
    @Value("5")
    private int guessCount;
    @Value("20")
    private int minNumber;


    @Bean
    @GuessCount
    public int getGuessCount()
    {
        return guessCount;
    }

    @Bean
    @MaxNumber
    public int getMaxNumber()
    {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int getMinNumber()
    {
        return minNumber;
    }

}
