package com.orange.assignment4.service;

import com.orange.assignment4.repository.PlayerRepository;
import com.orange.assignment4.repository.TeamRepository;
import com.orange.assignment4.DTO.PlayerDTO;
import com.orange.assignment4.entity.Player;
import com.orange.assignment4.entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class PlayerServiceImpl implements PlayerService{

    private PlayerRepository playerRepo;
    private TeamRepository teamRepo;


    public PlayerServiceImpl (TeamRepository teamRepo, PlayerRepository playerRepo){
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
    }
    @Override
    @Transactional
    public PlayerDTO createPlayer(PlayerDTO myPlayer) {
        Player player = new Player();
        player.setName(myPlayer.getName());
        player.setAge(myPlayer.getAge());
        player.setShirtNumber(myPlayer.getShirtNumber());

        Optional<Team> team = teamRepo.findById(myPlayer.getTeamId());
        if (team.isPresent()){
            player.setTeam(team.get());
        }
        else {
            throw new RuntimeException("Couldn't find team with id - " + myPlayer.getTeamId());
        }

        Player savedPlayer = playerRepo.save(player);
        return new PlayerDTO(savedPlayer.getName(), savedPlayer.getShirtNumber(), savedPlayer.getAge(), savedPlayer.getTeam().getId());
    }

    @Override
    @Transactional
    public PlayerDTO updatePlayer(PlayerDTO myPlayer, Long id) {
        Optional<Player> player = playerRepo.findById(id);
        Player toUpdate = new Player();

        if (player.isPresent()){
            toUpdate = player.get();
        }
        else {
            throw new RuntimeException("Cannot find Player with id - " + id);
        }

        toUpdate.setName(myPlayer.getName());
        toUpdate.setAge(myPlayer.getAge());
        toUpdate.setShirtNumber(myPlayer.getShirtNumber());

        Optional<Team> team = teamRepo.findById(myPlayer.getTeamId());
        if (team.isPresent()) {
            toUpdate.setTeam(team.get());
        } else {
            throw new RuntimeException("Couldn't find team with id - " + myPlayer.getTeamId());
        }

        Player savedPlayer = playerRepo.save(toUpdate);
        return new PlayerDTO(savedPlayer.getName(), savedPlayer.getShirtNumber(), savedPlayer.getAge(), savedPlayer.getTeam().getId());
    }
}
