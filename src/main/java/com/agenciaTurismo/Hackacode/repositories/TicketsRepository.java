package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, String>{
    
    @Query("SELECT t FROM Tickets WHERE t.name = :name")
    public Tickets findByName(@Param("name") String name);

}
