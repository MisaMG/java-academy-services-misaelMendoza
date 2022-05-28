package javaacademy.services.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javaacademy.services.entities.Student;
import javaacademy.services.repository.StudentRepository;

@Service
public class StudentServices {

    private final StudentRepository repository;

    private final Log LOGGER = LogFactory.getLog(StudentServices.class);

    public StudentServices(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student saveStudent(Student newStudent){
        LOGGER.debug("## The new student is " + newStudent);
        
        return repository.save(newStudent);
    }

    public Optional <Student> getStudentById (Long studentId){
        LOGGER.debug("## The student obtained is " + studentId);
        return repository.findById(studentId);
    }
    
}
