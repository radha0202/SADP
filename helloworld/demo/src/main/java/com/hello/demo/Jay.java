package com.hello.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Jay {
    @RequestMapping("/jay")
    public String jay()
    {
        return "<h1>Ganpati Bappa Morya..!</h1>";
    }
}




