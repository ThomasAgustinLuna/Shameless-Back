package com.agenciaTurismo.Hackacode.dtos;

public class ClientDto {

    private String name;
    private String surname;
    private String adress;
    private Integer dni;
    private String birthDate;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String clientId;



    public ClientDto() {
    }


    public ClientDto(String name, String surname, String adress, Integer dni, String birthDate, String nationality, String phoneNumber, String email, String clientId) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.dni = dni;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientId = clientId;
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

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    


}
