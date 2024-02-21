package com.agenciaTurismo.Hackacode.entities;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public abstract class User {

    protected String name;
    protected String surname;
    protected String adress;
    protected Integer dni;
    @Temporal(TemporalType.DATE)
    protected Date birthDate;
    protected String nationality;
    protected Long phoneNumb;
    protected String email;
    @Temporal(TemporalType.DATE)
    protected Date lastInteract;
    protected boolean status;


    public User() {
    }


    public User(String name, String surname, String adress, Integer dni, Date birthDate, String nationality, Long phoneNumb, String email, Date lastInteract, boolean status) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.dni = dni;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.lastInteract = lastInteract;
        this.status = status;
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

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Long getPhoneNumb() {
        return this.phoneNumb;
    }

    public void setPhoneNumb(Long phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastInteract() {
        return this.lastInteract;
    }

    public void setLastInteract(Date lastInteract) {
        this.lastInteract = lastInteract;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }




}
