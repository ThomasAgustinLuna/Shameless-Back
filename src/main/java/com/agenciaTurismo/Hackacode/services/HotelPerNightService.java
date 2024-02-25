package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.HotelPerNight;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.HotelPerNightRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HotelPerNightService {

    @Autowired
    private HotelPerNightRepository hotelPerNightRepository;

    @Transactional
    public void createHotelPerNight(String name, String descript, Date startDate, Double price, String ubication,
            Integer numbOfRooms) throws MyException {
        validate(name, descript, startDate, price, ubication, numbOfRooms);
        HotelPerNight hotelPerNight = new HotelPerNight();

        hotelPerNight.setName(name);
        hotelPerNight.setDescript(descript);
        hotelPerNight.setStartDate(startDate);
        hotelPerNight.setPrice(price);
        hotelPerNight.setUbication(ubication);
        hotelPerNight.setNumbOfRooms(numbOfRooms);
        hotelPerNight.setStatus(true);

        hotelPerNightRepository.save(hotelPerNight);

    }

    public List<HotelPerNight> ListHotel() {
        List<HotelPerNight> hotelPerNights = new ArrayList<>();

        hotelPerNights = hotelPerNightRepository.findByStatus(true);

        return hotelPerNights;
    }

    public void modifyHotel(String productCode, String name, String descript, Date startDate, Double price,
            String ubication, Integer numbOfRooms) throws MyException {
        if (productCode == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, descript, startDate, price, ubication, numbOfRooms);
        Optional<HotelPerNight> ans = hotelPerNightRepository.findById(productCode);

        if (ans.isPresent()) {
            HotelPerNight hotelPerNight = ans.get();
            if (hotelPerNight.isStatus()) {
                hotelPerNight.setName(name);
                hotelPerNight.setDescript(descript);
                hotelPerNight.setStartDate(startDate);
                hotelPerNight.setPrice(price);
                hotelPerNight.setUbication(ubication);
                hotelPerNight.setNumbOfRooms(numbOfRooms);

                hotelPerNightRepository.save(hotelPerNight);
            } else {
                throw new MyException("No hay registro de ese hotel");
            }

        }
    }

    private void validate(String name, String descript, Date startDate, Double price, String ubication,
            Integer numbOfRooms) throws MyException {
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
        if (ubication == null || ubication.isEmpty()) {
            throw new MyException("El tipo de ubicacion no puede ser nula");
        }
        if (numbOfRooms == null) {
            throw new MyException("La cantidad de habitaciones no puede ser nula");
        }
    }
}
