package com.example.cfttest.service.impls;

import com.example.cfttest.exeption.ProductsException;
import com.example.cfttest.model.entities.LaptopsEntity;
import com.example.cfttest.repository.LaptopsRepo;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LaptopsServiceImpl implements ProductsService<LaptopsEntity> {

    private LaptopsRepo laptopsRepo;

    @Override
    public LaptopsEntity save(LaptopsEntity product) {
        try {
            return laptopsRepo.save(product);
        }catch (IllegalArgumentException e){
            throw new ProductsException("Impossible to save the product");
        }
    }

    @Override
    public void edit(LaptopsEntity product, Long id) {
        Optional<LaptopsEntity> foundProduct = laptopsRepo.findById(id);
        foundProduct.ifPresentOrElse(
                order-> {
                    order.setScreenDiagonal(product.getScreenDiagonal());
                    order.setManufacturer(product.getManufacturer());
                    order.setPrice(product.getPrice());
                    order.setQuantityInStock(product.getQuantityInStock());
                    laptopsRepo.save(order);
                },
                ()-> {
                    throw new ProductsException("this product does not exist");
                }
        );
    }

    @Override
    public void delete(Long serialNumber) {
        laptopsRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
        laptopsRepo.deleteById(serialNumber);
    }

    @Override
    public List<LaptopsEntity> getAllProductsByCategory() {
        return laptopsRepo.findAll();
    }

    @Override
    public LaptopsEntity getProductBySerialNumber(Long serialNumber) {
        return laptopsRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
    }
}
