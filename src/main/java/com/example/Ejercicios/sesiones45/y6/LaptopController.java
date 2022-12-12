package com.example.Ejercicios.sesiones45.y6;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);


    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @GetMapping("/laptops")
    public List<Laptop> findAll() {

        return laptopRepository.findAll();
    }


    @GetMapping("/laptop/{id}")
    @ApiOperation("buscar libro por id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("CLAVER PRIMARIAID TIPO LONG") @PathVariable Long id) {

        Optional<Laptop> bookOpt = laptopRepository.findById(id);


        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }


    @PostMapping("/laptops")
    public Laptop addLaptop(@RequestBody Laptop laptop) {

        return laptopRepository.save(laptop);
    }

    @PutMapping("laptops")
    public ResponseEntity<Object> update(@RequestBody Laptop laptop) {

        if (laptop.getId() == null) {
            log.warn("error al modificar libro");
            return ResponseEntity.badRequest().build();

        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("NO SE ENCONTROL EL LIBRO QUE QUIERE MODIDIFCAR libro");
            return ResponseEntity.notFound().build();

        }
        Laptop result = laptopRepository.save(laptop);
        log.info("MODIFICADO");

        return ResponseEntity.ok(result);


    }

    @DeleteMapping("laptops")
    public ResponseEntity<Laptop> delete(@RequestBody Laptop laptop) {


        if (laptop.getId() == null) {
            log.warn("libro no encontrado");
            return ResponseEntity.badRequest().build();

        }

        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("la laptop que deseas eliminar no esta creado");
            return ResponseEntity.notFound().build();
        }


        laptopRepository.deleteById(laptop.getId());
        log.info("la laptop eliminada");

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("laptops/all")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("se ejecuto deleleAll");
        laptopRepository.deleteAll();

        return ResponseEntity.noContent().build();

    }
}
