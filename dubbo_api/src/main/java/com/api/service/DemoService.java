package com.api.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public interface DemoService {
    @RequestMapping("/aaa")
    String sayHello(String name);
}
