package dbernat.it.springmvc.core.config;

import dbernat.it.springmvc.core.qualifiers.GuessCount;
import dbernat.it.springmvc.core.qualifiers.MaxNumber;
import dbernat.it.springmvc.core.qualifiers.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "dbernat.it.springmvc")
@PropertySource("classpath:config/game.properties")
public class AppConfig
{
    @Value("${game.maxNumber:100}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;
    @Value("${game.minNumber:0}")
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
