package com.agenciaTurismo.Hackacode.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Excursion;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, String> {

    @Query("SELECT e FROM Excursion e WHERE e.name = :name")
    public Excursion findByName(@Param("name") String name);

    @Query("SELECT e FROM Excursion e WHERE e.status = :status")
    public List<Excursion> findByStatus(@Param("status") boolean status);
}
