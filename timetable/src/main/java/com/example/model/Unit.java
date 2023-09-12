package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Unit extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    public int day;
    public int unit;
    public String subject;

    @ManyToOne
    @JoinColumn
    public Schoolclass schoolclass;

    @ManyToOne
    @JoinColumn
    public Teacher teacher;

    public Unit(int day, int unit, String subject, Schoolclass schoolclass, Teacher teacher) {
        this.day = day;
        this.unit = unit;
        this.subject = subject;
        this.schoolclass = schoolclass;
        this.teacher = teacher;
    }

    public Unit() {
    }
}
