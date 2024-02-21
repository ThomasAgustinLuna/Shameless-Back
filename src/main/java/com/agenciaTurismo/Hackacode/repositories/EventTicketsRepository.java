package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.EventTickets;

@Repository
public interface EventTicketsRepository extends JpaRepository<EventTickets, String>{
    
    @Query("SELECT e FROM EventTickets WHERE e.name = :name")
    public EventTickets findByName(@Param("name") String name);
}
