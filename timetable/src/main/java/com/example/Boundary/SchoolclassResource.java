package com.example.Boundary;

import com.example.Repository.SchoolclassRepository;
import com.example.model.Schoolclass;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("class/")
public class SchoolclassResource {


    @Inject
    SchoolclassRepository schoolclassRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schoolclass> getAllClasses(){
        TypedQuery<Schoolclass> query = schoolclassRepository.getEntityManager().createNamedQuery("Schoolclass.findAll", Schoolclass.class);
        return query.getResultList();
       // return schoolclassRepository.listAll(Sort.ascending("id"));
    }
}
