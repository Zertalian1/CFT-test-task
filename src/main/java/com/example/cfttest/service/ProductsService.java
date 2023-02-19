package com.example.cfttest.service;

import com.example.cfttest.model.entities.ProductsEntity;
import java.util.List;

public interface ProductsService <T extends ProductsEntity>{
    T save(T product);
    void edit(T product, Long id);
    void delete(Long serialNumber);
    List<T> getAllProductsByCategory();
    T getProductBySerialNumber(Long serialNumber);
}
