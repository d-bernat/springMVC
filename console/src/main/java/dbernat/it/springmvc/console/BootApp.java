package dbernat.it.springmvc.console;

import dbernat.it.springmvc.core.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
class BootApp
{

    public static void main(String[] args)
    {
        log.info("the spring container is about to start ...");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.close();
    }
}