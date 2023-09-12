package com.example.Repository;

import com.example.model.Schoolclass;
import com.example.model.Unit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@ApplicationScoped
public class SchoolclassRepository implements PanacheRepositoryBase<Schoolclass, String> {



}
