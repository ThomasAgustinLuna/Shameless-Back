package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
    
    @Query("SELECT c FROM Client WHERE c.name = :name")
    public Client findByName(@Param("name") String name);
}
