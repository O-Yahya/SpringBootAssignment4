package com.orange.assignment4.service;

import com.orange.assignment4.repository.LeagueRepository;
import com.orange.assignment4.repository.TeamRepository;
import com.orange.assignment4.DTO.TeamDTO;
import com.orange.assignment4.entity.League;
import com.orange.assignment4.entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepo;
    private final LeagueRepository leagueRepo;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepo, LeagueRepository leagueRepo) {
        this.leagueRepo = leagueRepo;
        this.teamRepo = teamRepo;
    }

    @Override
    @Transactional
    public TeamDTO createTeam(TeamDTO teamDTO) {

        Team team = new Team();
        team.setName(teamDTO.getName());

        Optional<League> league = leagueRepo.findById(teamDTO.getLeagueId());

        if (league.isPresent()) {
            team.setLeague(league.get());
        } else {
            throw new RuntimeException("Couldn't find league with id - " + teamDTO.getLeagueId());
        }

        Team savedTeam = teamRepo.save(team);
        return new TeamDTO(savedTeam.getName(), savedTeam.getLeague().getId());
    }

    @Override
    @Transactional
    public TeamDTO updateTeam(TeamDTO myTeam, Long id) {
        Optional<Team> team = teamRepo.findById(id);
        Team toUpdate = new Team();

        if (team.isPresent()) {
            toUpdate = team.get();
        } else {
            throw new RuntimeException("Couldn't find team with id - " + id);
        }

        toUpdate.setName(myTeam.getName());

        Optional<League> league = leagueRepo.findById(myTeam.getLeagueId());
        if (league.isPresent()) {
            toUpdate.setLeague(league.get());
        } else {
            throw new RuntimeException("Couldn't find league with id - " + myTeam.getLeagueId());
        }

        Team savedTeam = teamRepo.save(toUpdate);
        return new TeamDTO(savedTeam.getName(), savedTeam.getLeague().getId());
    }
}
