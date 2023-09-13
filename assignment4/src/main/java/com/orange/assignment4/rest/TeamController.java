package com.orange.assignment4.rest;

import com.orange.assignment4.DTO.TeamDTO;
import com.orange.assignment4.entity.Team;
import com.orange.assignment4.service.TeamService;
import com.orange.assignment4.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamServiceImpl teamService){
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO){
        TeamDTO createdDTO = teamService.createTeam(teamDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody TeamDTO teamDTO, @PathVariable Long id){
        TeamDTO createdDTO = teamService.updateTeam(teamDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }
}
