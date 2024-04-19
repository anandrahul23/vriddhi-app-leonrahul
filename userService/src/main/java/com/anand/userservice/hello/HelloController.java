package com.anand.userservice.hello;

import com.anand.userservice.statistics.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    InstanceInformationService  instanceInformationService;
    @GetMapping("")
    public String  hello()
    {
        return "Hello from Rahul Anand root level, This confirms " +
                "deployment is working with ansible:"
                + instanceInformationService.retrieveInstanceInfo() ;
    }

    @GetMapping("hello")
    public String  welcomeFromHello()
    {
        return "Hello from Rahul Anand,  get mapping hello, " +
                " This confirms deployment is working with ansible:"
                + instanceInformationService.retrieveInstanceInfo();
    }
}
