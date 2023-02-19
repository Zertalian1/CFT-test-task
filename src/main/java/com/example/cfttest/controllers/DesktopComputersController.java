package com.example.cfttest.controllers;

import com.example.cfttest.model.entities.DesktopComputersEntity;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/desktopComputers")
@AllArgsConstructor
public class DesktopComputersController {

    private ProductsService<DesktopComputersEntity> desktopComputersService;

    @GetMapping( "")
    public ResponseEntity<List<DesktopComputersEntity>> getByType(){
        return ResponseEntity.ok().body(desktopComputersService.getAllProductsByCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesktopComputersEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(desktopComputersService.getProductBySerialNumber(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        desktopComputersService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody DesktopComputersEntity product){
        desktopComputersService.edit(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<DesktopComputersEntity> add(@RequestBody DesktopComputersEntity product){
        return ResponseEntity.ok().body(desktopComputersService.save(product));
    }

}
