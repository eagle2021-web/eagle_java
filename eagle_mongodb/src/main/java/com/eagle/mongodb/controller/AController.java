package com.eagle.mongodb.controller;

import com.eagle.mongodb.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taco")
public class AController {
    @Autowired
    private TacoService tacoService;

    @GetMapping("add")
    public String add() {
        tacoService.add();
        return "Ok";
    }
}
