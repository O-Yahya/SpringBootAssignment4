package com.orange.assignment4.service;

import com.orange.assignment4.repository.LeagueRepository;
import com.orange.assignment4.repository.RefereeRepository;
import com.orange.assignment4.DTO.RefereeDTO;
import com.orange.assignment4.entity.League;
import com.orange.assignment4.entity.Referee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
@Service
public class RefereeServiceImpl implements RefereeService{

    private final RefereeRepository refereeRepo;
    private final LeagueRepository leagueRepo;

    public RefereeServiceImpl(RefereeRepository refereeRepo, LeagueRepository leagueRepo){
        this.leagueRepo = leagueRepo;
        this.refereeRepo = refereeRepo;
    }

    @Override
    @Transactional
    public RefereeDTO createReferee(RefereeDTO myReferee) {
        Referee referee = new Referee();
        referee.setName(myReferee.getName());
        referee.setAge(myReferee.getAge());

        Optional<League> league = leagueRepo.findById(myReferee.getLeagueId());

        if (league.isPresent()) {
            referee.setLeague(league.get());
        } else {
            throw new RuntimeException("Couldn't find league with id - " + myReferee.getLeagueId());
        }


        Referee savedReferee = refereeRepo.save(referee);
        return new RefereeDTO(savedReferee.getName(), savedReferee.getAge(), savedReferee.getLeague().getId());
    }

    @Override
    @Transactional
    public RefereeDTO updateReferee(RefereeDTO myReferee, Long id) {
        Optional<Referee> referee = refereeRepo.findById(id);
        Referee toUpdate = new Referee();

        if (referee.isPresent()) {
            toUpdate = referee.get();
        } else {
            throw new RuntimeException("Couldn't find referee with id - " + id);
        }

        toUpdate.setName(myReferee.getName());
        toUpdate.setAge(myReferee.getAge());

        Optional<League> league = leagueRepo.findById(myReferee.getLeagueId());
        if (league.isPresent()) {
            toUpdate.setLeague(league.get());
        } else {
            throw new RuntimeException("Couldn't find league with id - " + myReferee.getLeagueId());
        }

        Referee savedReferee = refereeRepo.save(toUpdate);
        return new RefereeDTO(savedReferee.getName(), savedReferee.getAge(), savedReferee.getLeague().getId());
    }
}
