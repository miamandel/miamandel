package com.example.Boundary;

import com.example.Repository.UnitRepository;
import com.example.model.Unit;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.getEntityManager;
import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@Path("unit/")
public class UnitResource {

    @Inject
    UnitRepository unitRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("class/{klasse}")
    public List<Unit> getAllUnits(@PathParam("klasse") String id){
        return unitRepository.list("schoolclass.id", id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Unit save(Unit unit){
        return unitRepository.save(unit);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("unit/{id}")
    @Transactional
    public void deleteUnit(@PathParam("id") Long id){
        unitRepository.deleteById(id);
    }
}
