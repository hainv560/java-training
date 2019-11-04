package com.hainv.training.repository.student;

import com.hainv.training.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Created by Hainv on 2019-11-04
 * @project docker-compose
 */
public interface StudentRepository extends CrudRepository<Student,Long> ,StudentRepositoryCustom{
}
