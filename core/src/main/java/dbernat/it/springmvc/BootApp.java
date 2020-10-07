package dbernat.it.springmvc;

import dbernat.it.springmvc.services.Game;
import dbernat.it.springmvc.services.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootApp
{
    private static final Logger log = LoggerFactory.getLogger(BootApp.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args)
    {
        log.info("spring container is about to start ...");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGeneratorImpl = context.getBean("numberGenerator", NumberGenerator.class);
        int number = numberGeneratorImpl.next();

        Game game = context.getBean("game", Game.class);
        //game.reset();

        log.info(Integer.toString(number));
        context.close();
    }
}