package com.anand.userservice.hello;

import com.anand.userservice.statistics.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    InstanceInformationService instanceInformationService;

    private String getPodName() {
        return System.getenv("HOSTNAME");
    }

    private String getJarVersion() {
        String version = "unknown";
        try {
            Manifest manifest = new Manifest(
                    getClass().getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));
            Attributes attr = manifest.getMainAttributes();
            version = attr.getValue("Implementation-Version");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return version;
    }

    @GetMapping("")
    public String hello() {
        String podName = getPodName();
        String jarVersion = getJarVersion();
        return "Hello from User Service root level. This confirms argo rollout is working with blue green strategy. " +
                "Pod Name: " + podName + ", JAR Version: " + jarVersion + " " +
                instanceInformationService.retrieveInstanceInfo();
    }

    @GetMapping("hello")
    public String welcomeFromHello() {
        String podName = getPodName();
        String jarVersion = getJarVersion();
        return "Hello from User Service, get mapping hello. This confirms argo rollout is working with blue green strategy "
                +
                "Pod Name: " + podName + ", JAR Version: " + jarVersion + " " +
                instanceInformationService.retrieveInstanceInfo();
    }
}
