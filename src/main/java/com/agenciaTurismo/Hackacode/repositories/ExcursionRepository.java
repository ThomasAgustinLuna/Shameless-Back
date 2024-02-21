package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Excursion;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, String>{
    
    @Query("SELECT e FROM Excursion WHERE e.name = :name")
    public Excursion findByName(@Param("name") String name);
}
