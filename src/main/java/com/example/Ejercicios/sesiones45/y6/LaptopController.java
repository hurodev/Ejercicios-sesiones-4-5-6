package com.example.Ejercicios.sesiones45.y6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @GetMapping("/laptops")
    public List<Laptop> findAll (){

        return laptopRepository.findAll();
    }

    @PostMapping("/laptops")
    public Laptop addLaptop(@RequestBody Laptop laptop){

        return laptopRepository.save(laptop);

    }



}
