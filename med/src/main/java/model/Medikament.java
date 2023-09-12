package model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medikament extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String hersteller;

    private double preis;

    public Medikament(String name, String hersteller, double preis) {
        this.name = name;
        this.hersteller = hersteller;
        this.preis = preis;
    }

    public Medikament() {
    }

    @Override
    public String toString() {
        return "Medikament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hersteller='" + hersteller + '\'' +
                ", preis=" + preis +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}

