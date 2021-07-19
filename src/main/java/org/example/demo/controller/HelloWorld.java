package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public String helloworld(){
        System.out.println("success into helloworld but this demo should add controller");
        return "helloworld!";
    }
}
