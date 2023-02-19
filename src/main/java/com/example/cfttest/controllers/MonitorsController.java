package com.example.cfttest.controllers;

import com.example.cfttest.model.entities.MonitorsEntity;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/monitors")
@AllArgsConstructor
public class MonitorsController {
    private ProductsService<MonitorsEntity> monitorsService;

    @GetMapping( "")
    public ResponseEntity<List<MonitorsEntity>> getByType(){
        return ResponseEntity.ok().body(monitorsService.getAllProductsByCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorsEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(monitorsService.getProductBySerialNumber(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monitorsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody MonitorsEntity product){
        monitorsService.edit(product, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<MonitorsEntity> add(@RequestBody MonitorsEntity product){
        return ResponseEntity.ok().body(monitorsService.save(product));
    }
}
