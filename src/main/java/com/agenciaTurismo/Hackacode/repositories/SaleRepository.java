package com.agenciaTurismo.Hackacode.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE s.client.name = :name")
    public Sale findByClient(@Param("name") String name);

    @Query("SELECT s FROM Sale s WHERE s.status = :status")
    public List<Sale> findByStatus(@Param("status") boolean status);
}
