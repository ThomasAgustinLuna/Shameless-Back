package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Product;
import com.agenciaTurismo.Hackacode.entities.TouristPackage;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.TouristPackageRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TouristPackageService {

    @Autowired
    private TouristPackageRepository touristPackageRepository;

    @Transactional
    public void createTouristPackage(String name, String descript, Date startDate,
            List<Product> products) throws MyException {

        validate(name, descript, startDate, products);
        TouristPackage touristPackage = new TouristPackage();
        touristPackage.setName(name);
        touristPackage.setDescript(descript);
        touristPackage.setStartDate(startDate);
        touristPackage.setPrice(discount(products));
        touristPackage.setProducts(products);
        touristPackage.setStatus(true);

        touristPackageRepository.save(touristPackage);

    }

    public List<TouristPackage> ListTouristPackages() {
        List<TouristPackage> touristPackages = new ArrayList<>();

        touristPackages = touristPackageRepository.findByStatus(true);

        return touristPackages;
    }

    public void modifyTouristPackage(String productCode, String name, String descript, Date startDate, Double price,
            List<Product> products) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, products);
        Optional<TouristPackage> ans = touristPackageRepository.findById(productCode);

        if (ans.isPresent()) {
            TouristPackage touristPackage = ans.get();
            if (touristPackage.isStatus()) {
                touristPackage.setName(name);
                touristPackage.setDescript(descript);
                touristPackage.setStartDate(startDate);
                touristPackage.setPrice(price);
                touristPackage.setProducts(products);

                touristPackageRepository.save(touristPackage);
            } else {
                throw new MyException("No hay registro de ese paquete");
            }

        }

    }

    public void deleteTouristPackage(String productCode) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        Optional<TouristPackage> ans = touristPackageRepository.findById(productCode);

        if (ans.isPresent()) {
            TouristPackage touristPackage = ans.get();
            if (touristPackage.isStatus()) {
                touristPackage.setStatus(false);
            }
        }

    }

    private void validate(String name, String descript, Date startDate, List<Product> products)
            throws MyException {
        if (name == null || name.isEmpty()) {
            throw new MyException("El nombre no puede ser nulo");
        }
        if (descript == null || descript.isEmpty()) {
            throw new MyException("La descripcion no puede ser nula");
        }
        if (startDate == null) {
            throw new MyException("La fecha inicial no puede ser nula");
        }
        if (products == null || products.isEmpty()) {
            throw new MyException("El paquete de productos no puede ser nulo o estar vacio");
        }

    }

    private Double discount(List<Product> products) {

        Double priceAux = 0.0;

        if (products.size() > 1) {
            for (Product product : products) {
                priceAux += product.getPrice();

            }
            return priceAux = priceAux - priceAux*0.1;
        }else{
            for (Product product : products) {
                priceAux = product.getPrice();
            }
            return priceAux;
        }

    }

}
