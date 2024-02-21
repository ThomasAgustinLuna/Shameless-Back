package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.TouristPackage;

@Repository
public interface TouristPackageRepository extends JpaRepository<TouristPackage, String>{
    
    @Query("SELECT t FROM TouristPackage WHERE t.name = :name")
    public TouristPackage findByName(@Param("name") String name);
    
}
