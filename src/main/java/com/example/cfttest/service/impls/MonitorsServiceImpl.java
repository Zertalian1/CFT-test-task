package com.example.cfttest.service.impls;

import com.example.cfttest.exeption.ProductsException;
import com.example.cfttest.model.entities.HardDrivesEntity;
import com.example.cfttest.model.entities.MonitorsEntity;
import com.example.cfttest.model.entities.ProductsEntity;
import com.example.cfttest.repository.MonitorsRepo;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MonitorsServiceImpl implements ProductsService<MonitorsEntity> {

    private MonitorsRepo monitorsRepo;

    @Override
    public MonitorsEntity save(MonitorsEntity product) {
        try {
            return monitorsRepo.save(product);
        }catch (IllegalArgumentException e){
            throw new ProductsException("Impossible to save the product");
        }
    }

    @Override
    public void edit(MonitorsEntity product, Long id) {
        Optional<MonitorsEntity> foundProduct = monitorsRepo.findById(id);
        foundProduct.ifPresentOrElse(
                order-> {
                    order.setDiagonal(product.getDiagonal());
                    order.setManufacturer(product.getManufacturer());
                    order.setPrice(product.getPrice());
                    order.setQuantityInStock(product.getQuantityInStock());
                    monitorsRepo.save(order);
                },
                ()-> {
                    throw new ProductsException("this product does not exist");
                }
        );
    }

    @Override
    public void delete(Long serialNumber) {
        monitorsRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
        monitorsRepo.deleteById(serialNumber);
    }

    @Override
    public List<MonitorsEntity> getAllProductsByCategory() {
        return monitorsRepo.findAll();
    }

    @Override
    public MonitorsEntity getProductBySerialNumber(Long serialNumber) {
        return monitorsRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
    }
}
