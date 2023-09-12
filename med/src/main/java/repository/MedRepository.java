package repository;

import model.Medikament;
import model.Patient;
import model.Verschreibung;
import model.medDTO;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MedRepository {


    @Inject
    EntityManager em;

    public List<Patient> getPatients(){
        TypedQuery<Patient> query = em.createQuery("select p from Patient p", Patient.class);
        return query.getResultList();
    }

    public Patient getPatientsbyFirstname(String firstname) {
        TypedQuery<Patient> query = em.createQuery("select p from Patient p where p.firstname = :firstname", Patient.class);
        query.setParameter("firstname", firstname);
        return query.getSingleResult();
    }

    public List<Verschreibung> getVerschreibungen(){
        TypedQuery<Verschreibung> query = em.createQuery("select v from Verschreibung v", Verschreibung.class);
        return query.getResultList();
    }

    public Medikament getTopMedikament(){
        Query query = em.createQuery("select new model.medDTO(m.id, count(v.medikament.id)) from Medikament m, Verschreibung v where m.id = v.medikament.id group by m.id order by 2 desc");
        query.setMaxResults(1);
        medDTO medDTO = (model.medDTO) query.getSingleResult();
        TypedQuery<Medikament> query1 = em.createQuery("select m from Medikament m where m.id = ?1", Medikament.class);
        query1.setParameter(1, medDTO.m_id);
        return query1.getSingleResult();
    }

    public List<medDTO> getAllMedikamentwithAmountofVerschreibungen(){
        Query query = em.createQuery("select new model.medDTO(m.id, count(v.medikament.id)) from Medikament m, Verschreibung v where m.id = v.medikament.id group by m.id");
        List<medDTO> medDTOList = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            medDTO medDTO = (model.medDTO) query.getResultList().get(i);
            medDTOList.add(medDTO);
        }

        Query query1 = em.createQuery("select new model.medDTO(m.id) from Medikament m where m.id not in (select m.id from Medikament m, Verschreibung v where m.id = v.medikament.id)");
        for (int i = 0; i < query1.getResultList().size(); i++) {
            medDTO medDTO = (model.medDTO) query1.getResultList().get(i);
            medDTOList.add(medDTO);
        }
        return medDTOList;
    }

    @Transactional
    public void addVerschreibung(LocalDate gebDatum, int svnr, Long id){
        TypedQuery<Patient> patientQuery = em.createQuery("select p from Patient p where p.patientGebdatumSvnr.gebDatum =: gebDatum and p.patientGebdatumSvnr.svnr =: svnr", Patient.class);
        patientQuery.setParameter("gebDatum", gebDatum);
        patientQuery.setParameter("svnr", svnr);
        Patient patient = patientQuery.getSingleResult();

        TypedQuery<Medikament> medikamentQuery = em.createQuery("select m from Medikament m where m.id =: id", Medikament.class);
        medikamentQuery.setParameter("id", id);
        Medikament medikament = medikamentQuery.getSingleResult();

        Verschreibung verschreibung = new Verschreibung();
        verschreibung.setDate(LocalDate.now());
        verschreibung.setPatient(patient);
        verschreibung.setMedikament(medikament);

        em.persist(verschreibung);
    }

    @Transactional
    public void deleteVerschreibung(LocalDate gebDatum, int svnr, Long id){
        TypedQuery<Verschreibung> query = em.createQuery("select v from Verschreibung v where v.patient.patientGebdatumSvnr.gebDatum =: gebDatum and v.medikament.id =: id and v.patient.patientGebdatumSvnr.svnr =: svnr", Verschreibung.class);
        query.setParameter("gebDatum", gebDatum);
        query.setParameter("svnr", svnr);
        query.setParameter("id", id);
        Verschreibung verschreibung = query.getSingleResult();
        em.remove(verschreibung);
    }










}