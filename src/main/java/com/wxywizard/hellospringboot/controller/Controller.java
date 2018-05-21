package com.wxywizard.hellospringboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping(value = "/test{id}",method = RequestMethod.GET)
    public String test(@PathVariable(value = "id",required = true) String id){

        return id;
    }
}
