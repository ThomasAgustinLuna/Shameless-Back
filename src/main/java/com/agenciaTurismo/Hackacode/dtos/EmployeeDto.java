package com.agenciaTurismo.Hackacode.dtos;

import com.agenciaTurismo.Hackacode.enums.PositionType;

public class EmployeeDto {
    private String name;
    private String surname;
    private String adress;
    private Integer dni;
    private String birthDate;
    private String nationality;
    private String phoneNumber;
    private String email;
    private PositionType position;
    private Double salary;
    private String employeeId;



    public EmployeeDto() {
    }


    public EmployeeDto(String name, String surname, String adress, Integer dni, String birthDate, String nationality, String phoneNumber, String email, PositionType position, Double salary, String employeeId) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.dni = dni;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.employeeId = employeeId;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getDni() {
        return this.dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    

}
