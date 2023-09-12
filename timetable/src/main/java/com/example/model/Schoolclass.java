package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Schoolclass.findAll",
                query = "select s from Schoolclass s order by s.id asc"
        )
})
public class Schoolclass extends PanacheEntityBase {

    @Id
    public String id;

    public String room;

    public Schoolclass(String id, String room) {
        this.id = id;
        this.room = room;
    }

    public Schoolclass() {
    }
}

