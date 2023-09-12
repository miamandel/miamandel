package model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheEntity_;
import model.Medikament;
import model.Patient;
import org.jboss.resteasy.spi.touri.MappedBy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Verschreibung extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    @JoinColumn()
    private Medikament medikament;


    public Verschreibung(LocalDate date, Patient patient, Medikament medikament) {
        this.date = date;
        this.patient = patient;
        this.medikament = medikament;
    }

    public Verschreibung() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medikament getMedikament() {
        return medikament;
    }

    public void setMedikament(Medikament medikament) {
        this.medikament = medikament;
    }

    @Override
    public String toString() {
        return "Verschreibung{" +
                "id=" + id +
                ", date=" + date +
                ", patient=" + patient +
                ", medikament=" + medikament +
                '}';
    }
}
