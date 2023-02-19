package com.example.cfttest.controllers;


import com.example.cfttest.model.entities.LaptopsEntity;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/laptops")
@AllArgsConstructor
public class LaptopsController {

    private ProductsService<LaptopsEntity> laptopsService;

    @GetMapping( "")
    public ResponseEntity<List<LaptopsEntity>> getByType(){
        return ResponseEntity.ok().body(laptopsService.getAllProductsByCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopsEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(laptopsService.getProductBySerialNumber(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        laptopsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody LaptopsEntity product){
        laptopsService.edit(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<LaptopsEntity> add(@RequestBody LaptopsEntity product){
        return ResponseEntity.ok().body(laptopsService.save(product));
    }
}
