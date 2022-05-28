package javaacademy.services.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaacademy.services.entities.Student;
import javaacademy.services.service.StudentServices;


@RestController
@RequestMapping("/student")
public class StudentController {
    
    private final StudentServices service;
    private final Log LOGGER = LogFactory.getLog(StudentController.class);

    public StudentController(@Autowired StudentServices service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> fetchAllAcademy(){
        return ResponseEntity.ok().body(service.getAllStudents());
    }

    @PostMapping("")
    public ResponseEntity<Student> postStudent (@RequestBody Student newStudent) {
        System.out.println("--------- New student " + newStudent);
        LOGGER.error("###### New student " + newStudent);
        LOGGER.warn("###### New student " + newStudent);
        LOGGER.info("###### New student " + newStudent);
        LOGGER.debug("###### New student " + newStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(newStudent));
    }


    @GetMapping("/{studentId}")
        public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) {
            LOGGER.debug("## The student's id is " + studentId);

            return service.getStudentById(studentId)
                    .map(student -> ResponseEntity.ok().body(student))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        }
}
