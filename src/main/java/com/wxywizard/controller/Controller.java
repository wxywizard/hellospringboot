package com.wxywizard.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class Controller {

    @RequestMapping(value = "/test{id}",method = RequestMethod.GET)
    public String test(@PathVariable(value = "id",required = true) String id){

        log.info("id==={}",id);
        return id;
    }
}
