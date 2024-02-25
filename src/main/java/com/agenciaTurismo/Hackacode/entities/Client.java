package com.agenciaTurismo.Hackacode.entities;

import java.util.Date;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Client extends User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String clientId;
    private Integer milles;
    @ManyToOne
    private Sale sale;

    public Client() {
        this.milles = 100;
    }

    public Client(String clientId, Sale sale, String name, String surname, String adress, Integer dni, Date birthDate,
            String nationality, Long phoneNumb, String email, Date lastInteract, boolean status) {
        super(name, surname, adress, dni, birthDate, nationality, phoneNumb, email, lastInteract, status);
        this.clientId = clientId;
        this.milles = 100;
        this.sale = sale;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getMilles() {
        return this.milles;
    }

    public void setMilles(Integer milles) {
        this.milles = milles;
    }

}
