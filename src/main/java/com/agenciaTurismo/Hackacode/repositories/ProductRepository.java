package com.agenciaTurismo.Hackacode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.status = :status")
    public List<Product> findByStatus(@Param("status") boolean status);
}
