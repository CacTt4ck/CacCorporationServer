package com.tcaputi.back.caccorporationserver.client.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Client {

    public Client(String name, String email, String phone, String address, String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;


}
