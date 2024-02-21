package com.agenciaTurismo.Hackacode.entities;
import jakarta.persistence.Entity;
import java.util.Date;

import com.agenciaTurismo.Hackacode.enums.PositionType;

@Entity
public class Employee extends User{
    private String employeeId;
    private PositionType position;
    private Double salary;
    

    public Employee() {
    }

    public Employee(String employeeId,PositionType position,Double salary, String name, String surname, String adress, Integer dni, Date birthDate, String nationality, Long phoneNumb, String email, Date lastInteract, boolean status) {
        super(name, surname, adress, dni, birthDate, nationality, phoneNumb, email, lastInteract, status);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
    }
    

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public PositionType getPosition() {
        return this.position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
