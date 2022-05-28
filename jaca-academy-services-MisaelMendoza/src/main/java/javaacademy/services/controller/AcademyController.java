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

import javaacademy.services.entities.Academy;
import javaacademy.services.service.AcademyServices;


@RestController
@RequestMapping("/academy")
public class AcademyController {
    
    private final AcademyServices service;
    private final Log LOGGER = LogFactory.getLog(AcademyController.class);

    public AcademyController(@Autowired AcademyServices service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Academy>> fetchAllAcademy(){
        return ResponseEntity.ok().body(service.getAllAcademies());
    }

    @PostMapping("")
    public ResponseEntity<Academy> postAcademy (@RequestBody Academy newAcademy) {
        System.out.println("--------- New Academy " + newAcademy);
        LOGGER.error("###### New Academy ERROR " + newAcademy);
        LOGGER.warn("###### New Academy WARNING " + newAcademy);
        LOGGER.info("###### New Academy INFO " + newAcademy);
        LOGGER.debug("###### New Academy DEBUG" + newAcademy);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAcademy(newAcademy));
    }


    @GetMapping("/{academyId}")
        public ResponseEntity<Academy> getStudentById(@PathVariable("academyId") Long academyId) {
            LOGGER.debug("##### The Academy's id is ######" + academyId);

            return service.getAcademyById(academyId)
                    .map(academy -> ResponseEntity.ok().body(academy))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        }
}
