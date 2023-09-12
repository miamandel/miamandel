package com.example.Repository;

import com.example.model.Unit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UnitRepository implements PanacheRepositoryBase<Unit, Long> {

    @Inject
    EntityManager em;

    @Transactional
    public Unit save(Unit unit) {
        if (unit.id == null) {
            persist(unit);
            return unit;
        } else {
            return em.merge(unit);
        }
    }
}
