package com.agenciaTurismo.Hackacode.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.HotelPerNight;

@Repository
public interface HotelPerNightRepository extends JpaRepository<HotelPerNight, String> {

    @Query("SELECT h FROM HotelPerNight h WHERE h.name = :name")
    public HotelPerNight findByName(@Param("name") String name);

    @Query("SELECT h FROM HotelPerNight h WHERE h.status = :status")
    public List<HotelPerNight> findByStatus(@Param("status") boolean status);
}
