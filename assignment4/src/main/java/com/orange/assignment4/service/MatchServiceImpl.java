package com.orange.assignment4.service;

import com.orange.assignment4.repository.*;
import com.orange.assignment4.DTO.MatchDTO;
import com.orange.assignment4.DTO.ResultDTO;
import com.orange.assignment4.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
@Component
public class MatchServiceImpl implements MatchService{

    private LeagueRepository leagueRepo;
    private MatchRepository matchRepo;
    private TeamRepository teamRepo;
    private RefereeRepository refereeRepo;
    private PlayerRepository playerRepo;

    public MatchServiceImpl(LeagueRepository leagueRepo, RefereeRepository refereeRepository, MatchRepository matchRepository, TeamRepository teamRepository, PlayerRepository playerRepo){
        this.leagueRepo = leagueRepo;
        this.refereeRepo = refereeRepository;
        this.matchRepo = matchRepository;
        this.teamRepo = teamRepository;
        this.playerRepo = playerRepo;
    }
    @Override
    @Transactional
    public ResultDTO createMatch(MatchDTO myMatch) {
        Match match = new Match();
        ResultDTO resultDTO = new ResultDTO();

        Optional<League> league = leagueRepo.findById(myMatch.getLeagueId());
        if (league.isPresent()){
            match.setLeague(league.get());
        }
        else {
            throw new RuntimeException("Cannot find league with id - " + myMatch.getLeagueId());
        }

        Optional<Team> team1 = teamRepo.findById(myMatch.getTeam1id());
        if (team1.isPresent()){
            match.setTeam1(team1.get());
        }
        else {
            throw new RuntimeException("Cannot find team with id - " + myMatch.getTeam1id());
        }

        Optional<Team> team2 = teamRepo.findById(myMatch.getTeam2id());
        if (team2.isPresent()){
            match.setTeam2(team2.get());
        }
        else {
            throw new RuntimeException("Cannot find team with id - " + myMatch.getTeam2id());
        }

        Optional<Referee> referee = refereeRepo.findById(myMatch.getRefereeId());
        if (referee.isPresent()){
            match.setReferee(referee.get());
        }
        else {
            throw new RuntimeException("Cannot find referee with id - " + myMatch.getRefereeId());
        }

        resultDTO = simulateMatch(match);

        match.setDate(myMatch.getDate());

        if (Objects.equals(match.getTeam1().getName(), resultDTO.getWinner())){
            match.setWinner(match.getTeam1());
        }
        else {
            match.setWinner(match.getTeam2());
        }

        match.setResult(resultDTO.getResult());
        Match savedMatch = matchRepo.save(match);

        resultDTO.setTeam1(savedMatch.getTeam1().getName());
        resultDTO.setTeam2(savedMatch.getTeam2().getName());
        resultDTO.setLeague(savedMatch.getLeague().getName());
        resultDTO.setDate(savedMatch.getDate());
        resultDTO.setReferee(savedMatch.getReferee().getName());

        return resultDTO;
    }

    public ResultDTO simulateMatch(Match match){
        ResultDTO resultDTO = new ResultDTO();
        Random r = new Random();
        Team winner = match.getTeam1();
        Team loser = match.getTeam2();

        if (r.nextInt(10) % 2 == 0){
            winner = match.getTeam2();
            loser = match.getTeam1();
        }

        int winnerGoals = r.nextInt(10);
        int loserGoals = r.nextInt(winnerGoals+1);

        resultDTO.setResult(winnerGoals + " - " + loserGoals);
        resultDTO.setWinner(winner.getName());

        for (int i = 0; i<winnerGoals; i++){
            int x = r.nextInt(winner.getPlayers().size());
            resultDTO.getScorers().add(winner.getPlayers().get(x).getName());
        }
        for (int i = 0; i<loserGoals; i++){
            int z = r.nextInt(loser.getPlayers().size());
            resultDTO.getScorers().add(loser.getPlayers().get(z).getName());
        }

        return resultDTO;
    }
}
