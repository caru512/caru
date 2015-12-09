package com.caru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hello/{name}")
    public ModelAndView hello(@PathVariable("name") String name) {
        return new ModelAndView("hello_view").addObject("name", name);
    }
}