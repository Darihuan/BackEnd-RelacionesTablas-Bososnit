package com.example.relacionesentretablas.profesor.infrastructure.repository;

import com.example.relacionesentretablas.profesor.domain.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfesorRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;

    public List<Profesor> getData(HashMap<String,Object> conditions) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Profesor> query= cb.createQuery(Profesor.class);
        Root<Profesor> root= query.from(Profesor.class);

        List<Predicate> predicates=new ArrayList();
        conditions.forEach(
                (clave,valor)->{
                    switch (clave){
                        case "id":
                            predicates.add(cb.equal(root.get(clave),valor));
                            break;
                        case "idPersona":
                            predicates.add(cb.equal(root.get(clave),valor));
                            break;
                        case "coments":
                            predicates.add(cb.like(root.get(clave),"%"+valor+"%"));
                            break;
                        case "branch":
                            predicates.add(cb.like(root.get(clave),"%"+valor+"%"));
                            break;

                    }
                }
        );
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();

    }
}
