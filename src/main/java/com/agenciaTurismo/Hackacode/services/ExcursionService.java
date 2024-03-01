package com.agenciaTurismo.Hackacode.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Excursion;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.ExcursionRepository;
import jakarta.transaction.Transactional;

@Service
public class ExcursionService {

    @Autowired
    private ExcursionRepository excursionRepository;

    @Transactional
    public void createExcursion(String name, String descript, Date startDate, Double price, String destination,
            Double duration) throws MyException {
        validate(name, descript, startDate, price, destination, duration);

        Excursion excursion = new Excursion();

        excursion.setName(name);
        excursion.setDescript(descript);
        excursion.setStartDate(startDate);
        excursion.setPrice(price);
        excursion.setDestination(destination);
        excursion.setDuration(duration);
        excursion.setStatus(true);

        excursionRepository.save(excursion);

    }

    public List<Excursion> ListExcursions() {
        List<Excursion> excursions = new ArrayList<>();

        excursions = excursionRepository.findByStatus(true);

        return excursions;
    }

    public void modifyExcursion(String productCode, String name, String descript, Date startDate, Double price,
            String destination, Double duration) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, price, destination, duration);
        Optional<Excursion> ans = excursionRepository.findById(productCode);

        if (ans.isPresent()) {
            Excursion excursion = ans.get();
            if (excursion.isStatus()) {
                excursion.setName(name);
                excursion.setDescript(descript);
                excursion.setStartDate(startDate);
                excursion.setPrice(price);
                excursion.setDestination(destination);
                excursion.setDuration(duration);

                excursionRepository.save(excursion);
            } else {
                throw new MyException("No hay registro de esa excursion");
            }
        }
    }

    public void deleteExcursion(String productCode) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        Optional<Excursion> ans = excursionRepository.findById(productCode);

        if (ans.isPresent()) {
            Excursion excursion= ans.get();
            if (excursion.isStatus()) {
                excursion.setStatus(false);
            }
        }

    }

    private void validate(String name, String descript, Date startDate, Double price, String destination,
            Double duration) throws MyException {
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
        if (destination == null || destination.isEmpty()) {
            throw new MyException("El tipo de destino no puede ser nulo");
        }
        if (duration == null || duration.isNaN()) {
            throw new MyException("La duracion no puede ser nula");
        }
    }

}
