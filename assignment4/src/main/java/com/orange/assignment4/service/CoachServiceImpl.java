package com.orange.assignment4.service;

import com.orange.assignment4.repository.CoachRepository;
import com.orange.assignment4.repository.TeamRepository;
import com.orange.assignment4.DTO.CoachDTO;
import com.orange.assignment4.entity.Coach;
import com.orange.assignment4.entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CoachServiceImpl implements CoachService{

    private CoachRepository coachRepo;
    private TeamRepository teamRepo;


    public CoachServiceImpl (TeamRepository teamRepo, CoachRepository coachRepo){
        this.coachRepo = coachRepo;
        this.teamRepo = teamRepo;
    }
    @Override
    @Transactional
    public CoachDTO createCoach(CoachDTO myCoach) {
        Coach coach = new Coach();
        coach.setName(myCoach.getName());
        coach.setAge(myCoach.getAge());

        Optional<Team> team = teamRepo.findById(myCoach.getTeamId());
        if (team.isPresent()){
            coach.setTeam(team.get());
        }
        else {
            throw new RuntimeException("Couldn't find team with id - " + myCoach.getTeamId());
        }

        Coach savedCoach = coachRepo.save(coach);
        return new CoachDTO(savedCoach.getName(), savedCoach.getAge(), savedCoach.getTeam().getId());
    }

    @Override
    @Transactional
    public CoachDTO updateCoach(CoachDTO myCoach, Long id) {
        Optional<Coach> coach = coachRepo.findById(id);
        Coach toUpdate = new Coach();

        if (coach.isPresent()){
            toUpdate = coach.get();
        }
        else {
            throw new RuntimeException("Cannot find coach with id - " + id);
        }

        toUpdate.setName(myCoach.getName());
        toUpdate.setAge(myCoach.getAge());

        Optional<Team> team = teamRepo.findById(myCoach.getTeamId());
        if (team.isPresent()) {
            toUpdate.setTeam(team.get());
        } else {
            throw new RuntimeException("Couldn't find team with id - " + myCoach.getTeamId());
        }

        Coach savedCoach = coachRepo.save(toUpdate);
        return new CoachDTO(savedCoach.getName(), savedCoach.getAge(), savedCoach.getTeam().getId());
    }
}
