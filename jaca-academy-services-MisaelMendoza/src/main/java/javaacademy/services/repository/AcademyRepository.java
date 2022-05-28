package javaacademy.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javaacademy.services.entities.Academy;

    public interface  AcademyRepository extends JpaRepository <Academy, Long> {
    
}
