package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Teacher extends PanacheEntityBase {

    @Id
    public Long id;
    public String firstName;
    public String lastName;
    public String room;

    public Teacher(String firstName, String lastName, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.room = room;
    }

    public Teacher() {
    }
}
