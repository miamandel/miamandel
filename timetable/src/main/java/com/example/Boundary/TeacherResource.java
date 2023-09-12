package com.example.Boundary;

import com.example.Repository.TeacherRepository;
import com.example.model.Teacher;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("teacher")
public class TeacherResource {

    @Inject
    TeacherRepository teacherRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAllTeachers(){
        return teacherRepository.listAll(Sort.ascending("lastName", "firstName"));
    }
}
