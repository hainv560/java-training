package com.hainv.training.repository.classes;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Created by Hainv on 2019-11-05
 * @project docker-compose
 */
public class ClassRepositoryCustomImpl implements ClassRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

}
