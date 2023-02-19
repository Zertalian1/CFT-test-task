package com.example.cfttest.service.impls;

import com.example.cfttest.exeption.ProductsException;
import com.example.cfttest.model.entities.DesktopComputersEntity;
import com.example.cfttest.repository.DesktopComputersRepo;
import com.example.cfttest.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesktopComputersServiceImpl implements ProductsService<DesktopComputersEntity> {
    private DesktopComputersRepo desktopComputersRepo;


    @Override
    public DesktopComputersEntity save(DesktopComputersEntity product) {
        try {
            return desktopComputersRepo.save(product);
        }catch (IllegalArgumentException e){
            throw new ProductsException("Impossible to save the product");
        }
    }

    @Override
    public void edit(DesktopComputersEntity product, Long id) {
        Optional<DesktopComputersEntity> foundProduct = desktopComputersRepo.findById(id);
        foundProduct.ifPresentOrElse(
                order-> {
                    order.setFormFactor(product.getFormFactor());
                    order.setManufacturer(product.getManufacturer());
                    order.setPrice(product.getPrice());
                    order.setQuantityInStock(product.getQuantityInStock());
                    desktopComputersRepo.save(order);
                },
                ()-> {
                    throw new ProductsException("this product does not exist");
                }
        );
    }

    @Override
    public void delete(Long serialNumber) {
        desktopComputersRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
        desktopComputersRepo.deleteById(serialNumber);
    }

    @Override
    public List<DesktopComputersEntity> getAllProductsByCategory() {
        return desktopComputersRepo.findAll();
    }

    @Override
    public DesktopComputersEntity getProductBySerialNumber(Long serialNumber) {
        return desktopComputersRepo.findById(serialNumber).orElseThrow(
                ()-> new ProductsException("product with serial number:" + serialNumber + " does not exist")
        );
    }
}
