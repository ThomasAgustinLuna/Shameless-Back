package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
    
    @Query("SELECT s FROM Sale WHERE s.client.name = :name")
    public Sale findByClient(@Param("name") String name);
}
