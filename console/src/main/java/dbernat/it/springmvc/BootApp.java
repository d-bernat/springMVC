package dbernat.it.springmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
class BootApp
{

    public static void main(String[] args)
    {
        log.info("the spring container is about to start ...");
        SpringApplication.run(BootApp.class, args);
    }
}