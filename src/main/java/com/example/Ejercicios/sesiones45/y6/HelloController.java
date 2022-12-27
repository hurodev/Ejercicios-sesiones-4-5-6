package com.example.Ejercicios.sesiones45.y6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String hello(){
    return "hello world";
    }



    @GetMapping("/saludo1")
    public String hello1(){
        return "hello world";
    }



    @GetMapping("/saludo2")
    public String hello2(){
        return "hello world";
    }



}
