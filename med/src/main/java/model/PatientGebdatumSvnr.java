package model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class PatientGebdatumSvnr implements Serializable{


    private int svnr;
    private LocalDate gebDatum;

    public PatientGebdatumSvnr() {

    }


    public PatientGebdatumSvnr(int svnr, LocalDate gebDatum) {
        this.svnr = svnr;
        this.gebDatum = gebDatum;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(LocalDate gebDatum) {
        this.gebDatum = gebDatum;
    }

    public int getSvnr() {
        return svnr;
    }

    public void setSvnr(int svnr) {
        this.svnr = svnr;
    }

    @Override
    public String toString() {
        return "PatientGebdatumSvnr{" +
                "svnr=" + svnr +
                ", gebDatum=" + gebDatum +
                '}';
    }
}
