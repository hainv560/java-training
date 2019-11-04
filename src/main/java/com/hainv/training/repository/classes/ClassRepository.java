package com.hainv.training.repository.classes;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Created by Hainv on 2019-11-04
 * @project docker-compose
 */
public interface ClassRepository extends CrudRepository<Class,Long> ,ClassRepositoryCustom{
}
