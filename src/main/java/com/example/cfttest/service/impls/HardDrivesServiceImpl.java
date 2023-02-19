package com.example.cfttest.service.impls;

import com.example.cfttest.exeption.ProductsException;
import com.example.cfttest.model.entities.HardDrivesEntity;
import com.example.cfttest.repository.HardDrivesRepo;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardDrivesServiceImpl implements ProductsService<HardDrivesEntity> {

    private HardDrivesRepo hardDrivesRepo;

    @Override
    public HardDrivesEntity save(HardDrivesEntity product) {
        try {
            return hardDrivesRepo.save(product);
        }catch (IllegalArgumentException e){
            throw new ProductsException("Impossible to save the product");
        }
    }

    @Override
    public void edit(HardDrivesEntity product, Long id) {
        Optional<HardDrivesEntity> foundProduct = hardDrivesRepo.findById(id);
        foundProduct.ifPresentOrElse(
                order-> {
                    order.setCapacity(product.getCapacity());
                    order.setManufacturer(product.getManufacturer());
                    order.setPrice(product.getPrice());
                    order.setQuantityInStock(product.getQuantityInStock());
                    hardDrivesRepo.save(order);
                },
                ()-> {
                    throw new ProductsException("this product does not exist");
                }
        );
    }

    @Override
    public void delete(Long serialNumber) {
        hardDrivesRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
        hardDrivesRepo.deleteById(serialNumber);
    }

    @Override
    public List<HardDrivesEntity> getAllProductsByCategory() {
        return hardDrivesRepo.findAll();
    }

    @Override
    public HardDrivesEntity getProductBySerialNumber(Long serialNumber) {
        return hardDrivesRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
    }
}
