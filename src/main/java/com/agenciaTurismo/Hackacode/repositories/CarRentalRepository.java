package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.CarRental;
import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, String> {

    @Query("SELECT c FROM CarRental c WHERE c.carType = :cartype")
    public CarRental findByCarType(@Param("cartype") String carType);

    @Query("SELECT c FROM CarRental c WHERE c.status = :status")
    public List<CarRental> findByStatus(@Param("status") boolean status);
    

    /*
     * @Query("SELECT c FROM CarRental c  WHERE c.status = true")
     * List<CarRental> findActiveEntities();
     */
}
