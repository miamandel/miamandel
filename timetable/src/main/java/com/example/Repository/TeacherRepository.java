package com.example.Repository;

import com.example.model.Teacher;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeacherRepository implements PanacheRepositoryBase<Teacher, Long> {
}
