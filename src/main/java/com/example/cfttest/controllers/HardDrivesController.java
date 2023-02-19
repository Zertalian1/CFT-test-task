package com.example.cfttest.controllers;


import com.example.cfttest.model.entities.HardDrivesEntity;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/hardDrives")
@AllArgsConstructor
public class HardDrivesController {

    private ProductsService<HardDrivesEntity> hardDrivesService;

    @GetMapping( "")
    public ResponseEntity<List<HardDrivesEntity>> getByType(){
        return ResponseEntity.ok().body(hardDrivesService.getAllProductsByCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDrivesEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(hardDrivesService.getProductBySerialNumber(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        hardDrivesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody HardDrivesEntity product){
        hardDrivesService.edit(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<HardDrivesEntity> add(@RequestBody HardDrivesEntity product){
        return ResponseEntity.ok().body(hardDrivesService.save(product));
    }
}
