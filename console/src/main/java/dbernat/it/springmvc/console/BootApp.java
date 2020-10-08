package dbernat.it.springmvc.console;

import dbernat.it.springmvc.core.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootApp
{
    private static final Logger log = LoggerFactory.getLogger(BootApp.class);

    public static void main(String[] args)
    {
        log.info("the spring container is about to start ...");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.close();
    }
}