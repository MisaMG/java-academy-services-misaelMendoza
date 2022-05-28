package javaacademy.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javaacademy.services.entities.Student;

    public interface  StudentRepository extends JpaRepository <Student, Long> {
    
}
