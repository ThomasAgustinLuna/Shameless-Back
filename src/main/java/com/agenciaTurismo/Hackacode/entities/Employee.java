package com.agenciaTurismo.Hackacode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.hibernate.annotations.GenericGenerator;
import com.agenciaTurismo.Hackacode.enums.PositionType;

@Entity
public class Employee extends User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String employeeId;
    private PositionType position;
    private Double salary;
    @ManyToOne
    private Sale sale;

    public Employee() {
    }

    public Employee(String employeeId, PositionType position, Double salary, Sale sale, String name, String surname,
            String adress, Integer dni, Date birthDate, String nationality, Long phoneNumb, String email,
            Date lastInteract, boolean status) {
        super(name, surname, adress, dni, birthDate, nationality, phoneNumb, email, lastInteract, status);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.sale = sale;
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

    public Sale getSale() {
        return this.sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
