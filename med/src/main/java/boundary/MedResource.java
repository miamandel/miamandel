package boundary;

import model.Medikament;
import model.Patient;
import model.Verschreibung;
import model.medDTO;
import repository.MedRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("api/")
public class MedResource {

    @Inject
    MedRepository medRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPatients")
    public List<Patient> getPatients(){
        return medRepository.getPatients();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getPatientbyFirstname/{firstname}")
    public Patient getPatientsbyFirstname(@PathParam("firstname") String firstname){
        return medRepository.getPatientsbyFirstname(firstname);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getVerschreibung")
    public List<Verschreibung> getVerschreibungen(){
        return medRepository.getVerschreibungen();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTopMedikament")
    public Medikament getTopMedikament(){
        return medRepository.getTopMedikament();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllMedikamentwithAmountofVerschreibungen")
    public List<medDTO> getAllMedikamentwithAmountofVerschreibungen(){
        return medRepository.getAllMedikamentwithAmountofVerschreibungen();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addVerschreibung/{gebDatum}/{svnr}/{id}")
    public void addVerschreibung(@PathParam("gebDatum")String gebDatum, @PathParam("svnr") int svnr, @PathParam("id") Long id){
        medRepository.addVerschreibung(LocalDate.parse(gebDatum), svnr,id);
    }
}
