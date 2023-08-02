package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("foo")
public class FooController {

    @Value("#{systemEnvironment['JAVA_HOME']}")
    String javaHome;

    @Value("$(systemProperties.monthly.text)")
    String string2;

    @Value("#{systemProperties['monthly.text']}")
    String string3;

    @GetMapping("/bar")
    String foo(){
        System.out.println("string2 = " + string2);
        System.out.println("string3 = " + string3);
        return javaHome;
    }

}

// http://localhost:8080/bar
// D:\tools\graalvm-jdk-20.0.1+9.1