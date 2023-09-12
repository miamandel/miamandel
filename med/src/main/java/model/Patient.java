package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Patient implements Serializable{

    @EmbeddedId
    private PatientGebdatumSvnr patientGebdatumSvnr;

    private String firstname;
    private String lastname;

    public Patient() {
    }

    public Patient(PatientGebdatumSvnr patientGebdatumSvnr, String firstname, String lastname) {
        this.patientGebdatumSvnr = patientGebdatumSvnr;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public PatientGebdatumSvnr getPatientGebdatumSvnr() {
        return patientGebdatumSvnr;
    }

    public void setPatientGebdatumSvnr(PatientGebdatumSvnr patientGebdatumSvnr) {
        this.patientGebdatumSvnr = patientGebdatumSvnr;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientGebdatumSvnr=" + patientGebdatumSvnr +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
