package com.example.springdatajpaboot.controller;

import com.example.springdatajpaboot.entity.Cat;
import com.example.springdatajpaboot.mapper.CatMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class CatController {

    @Resource
    private CatMapper catMapper;

    @GetMapping("/demo")
    public void demo() {
        Iterable<Cat> all = catMapper.findAll();
        for (Cat cat : all) {
            System.out.println(cat);
        }
    }
}
