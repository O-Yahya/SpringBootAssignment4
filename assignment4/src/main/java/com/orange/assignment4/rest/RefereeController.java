package com.orange.assignment4.rest;

import com.orange.assignment4.DTO.RefereeDTO;
import com.orange.assignment4.service.RefereeService;
import com.orange.assignment4.service.RefereeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class RefereeController {

    private final RefereeService refereeService;

    @Autowired
    public RefereeController(RefereeServiceImpl refereeService){
        this.refereeService = refereeService;
    }

    @PostMapping("/referees")
    public ResponseEntity<RefereeDTO> createReferee (@RequestBody  RefereeDTO refereeDTO){
        RefereeDTO createdDTO = refereeService.createReferee(refereeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @PutMapping("/referees/{id}")
    public ResponseEntity<RefereeDTO> updateReferee (@RequestBody RefereeDTO refereeDTO, @PathVariable Long id){
        RefereeDTO createdDTO = refereeService.updateReferee(refereeDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

}
