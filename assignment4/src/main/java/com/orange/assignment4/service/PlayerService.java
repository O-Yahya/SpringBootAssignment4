package com.orange.assignment4.service;

import com.orange.assignment4.DTO.PlayerDTO;
import com.orange.assignment4.DTO.RefereeDTO;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO myPlayer);
    PlayerDTO updatePlayer(PlayerDTO myPlayer, Long id);
}
