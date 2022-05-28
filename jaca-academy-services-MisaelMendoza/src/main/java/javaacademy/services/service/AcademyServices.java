package javaacademy.services.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javaacademy.services.entities.Academy;
import javaacademy.services.repository.AcademyRepository;

@Service
public class AcademyServices {

    private final AcademyRepository repository;

    private final Log LOGGER = LogFactory.getLog(AcademyServices.class);

    public AcademyServices(AcademyRepository repository) {
        this.repository = repository;
    }

    public List<Academy> getAllAcademies(){
        return repository.findAll();
    }

    public Academy saveAcademy(Academy newAcademy){
        LOGGER.debug("## The new Academy is " + newAcademy);
        
        return repository.save(newAcademy);
    }

    public Optional <Academy> getAcademyById (Long academyId){
        LOGGER.debug("## The Academy obtained is " + academyId);
        return repository.findById(academyId);
    }
    
}
