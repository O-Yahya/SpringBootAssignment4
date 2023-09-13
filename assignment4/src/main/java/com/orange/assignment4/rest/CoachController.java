package com.orange.assignment4.rest;

import com.orange.assignment4.DTO.CoachDTO;
import com.orange.assignment4.DTO.PlayerDTO;
import com.orange.assignment4.service.CoachService;
import com.orange.assignment4.service.CoachServiceImpl;
import com.orange.assignment4.service.PlayerService;
import com.orange.assignment4.service.PlayerServiceImpl;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
@RepositoryRestResource(path = "/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachServiceImpl coachService){
        this.coachService = coachService;
    }

    @PostMapping("/coaches")
    public ResponseEntity<CoachDTO> createCoach (@RequestBody CoachDTO coachDTO){
        CoachDTO createdDTO = coachService.createCoach(coachDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @PutMapping("/coaches/{id}")
    public ResponseEntity<CoachDTO> updatePlayer (@RequestBody CoachDTO coachDTO, @PathVariable Long id){
        CoachDTO createdDTO = coachService.updateCoach(coachDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }
}
