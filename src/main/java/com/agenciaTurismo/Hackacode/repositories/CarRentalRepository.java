package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.CarRental;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, String>{
    
    @Query("SELECT c FROM CarRental WHERE c.cartype = :cartype")
    public CarRental findByCarType(@Param("cartype") String carType);
}
