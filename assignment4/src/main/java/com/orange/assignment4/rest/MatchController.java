package com.orange.assignment4.rest;

import com.orange.assignment4.DTO.MatchDTO;
import com.orange.assignment4.DTO.ResultDTO;
import com.orange.assignment4.service.MatchService;
import com.orange.assignment4.service.MatchServiceImpl;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
@RepositoryRestResource(path = "/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController (MatchServiceImpl matchService){
        this.matchService = matchService;
    }

    @PostMapping("/matches")
    public ResponseEntity<ResultDTO> createMatch(@RequestBody MatchDTO matchDTO){
        ResultDTO resultDTO = matchService.createMatch(matchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultDTO);
    }
}
