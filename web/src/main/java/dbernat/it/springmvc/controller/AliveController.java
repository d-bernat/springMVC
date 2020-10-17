package dbernat.it.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController
{
    @GetMapping("monitoring/alive")
    public String alive()
    {
        return "I am ok, :-)";
    }

    @GetMapping("monitoring/health")
    public String health()
    {
        return "I am healthy, ;-)";
    }
}
