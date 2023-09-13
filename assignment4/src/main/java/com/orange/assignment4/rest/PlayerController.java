package com.orange.assignment4.rest;

import com.orange.assignment4.DTO.PlayerDTO;
import com.orange.assignment4.service.PlayerService;
import com.orange.assignment4.service.PlayerServiceImpl;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerServiceImpl playerService){
        this.playerService = playerService;
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerDTO> createPlayer (@RequestBody PlayerDTO playerDTO){
        PlayerDTO createdDTO = playerService.createPlayer(playerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer (@RequestBody PlayerDTO playerDTO, @PathVariable Long id){
        PlayerDTO createdDTO = playerService.updatePlayer(playerDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }
}
