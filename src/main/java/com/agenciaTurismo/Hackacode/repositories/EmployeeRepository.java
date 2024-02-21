package com.agenciaTurismo.Hackacode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agenciaTurismo.Hackacode.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    
    @Query("SELECT e FROM Employee WHERE e.name = :name")
    public Employee findByName(@Param("name") String name);
}