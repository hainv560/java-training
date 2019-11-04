package com.hainv.training.controller;

import com.hainv.training.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by Hainv on 2019-11-04
 * @project docker-compose
 */
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final static Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity createStudent(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@PathVariable(required = true) String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable(required = true) String id){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable(required = true) String id){
        return null;
    }
}
