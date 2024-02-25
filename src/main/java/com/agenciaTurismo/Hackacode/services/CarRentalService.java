package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.CarRental;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.CarRentalRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarRentalService {

    @Autowired
    private CarRentalRepository carRentalRepository;

    @Transactional
    public void createCarRental(String name, String descript, Date startDate, Double price, String carType,
            Date deadLineDate) throws MyException {
        validate(name, descript, startDate, price, carType, deadLineDate);
        CarRental carRental = new CarRental();

        carRental.setName(name);
        carRental.setDescript(descript);
        carRental.setStartDate(startDate);
        carRental.setPrice(price);
        carRental.setCarType(carType);
        carRental.setDeadLineDate(deadLineDate);
        carRental.setStatus(true);

        carRentalRepository.save(carRental);

    }

    public List<CarRental> ListCarRentals() {

        List<CarRental> carRentals = new ArrayList<>();

        carRentals = carRentalRepository.findByStatus(true);

        return carRentals;
    }

    public void modifyCarRental(String productCode, String name, String descript, Date startDate, Double price,
            String carType, Date deadLineDate) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, price, carType, deadLineDate);
        Optional<CarRental> ans = carRentalRepository.findById(productCode);

        if (ans.isPresent()) {
            CarRental carRental = ans.get();
            if (carRental.isStatus()) {
                carRental.setName(name);
                carRental.setDescript(descript);
                carRental.setStartDate(startDate);
                carRental.setPrice(price);
                carRental.setCarType(carType);
                carRental.setDeadLineDate(deadLineDate);

                carRentalRepository.save(carRental);
            } else {
                throw new MyException("No hay registro de esa renta");
            }

        }
    }

    private void validate(String name, String descript, Date startDate, Double price, String carType, Date deadLineDate)
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
        if (price == null || price.isNaN()) {
            throw new MyException("El precio no puede ser nulo");
        }
        if (carType == null || carType.isEmpty()) {
            throw new MyException("El tipo de auto no puede ser nulo");
        }
        if (deadLineDate == null) {
            throw new MyException("La fecha de entrega no puede ser nula");
        }
    }

}
