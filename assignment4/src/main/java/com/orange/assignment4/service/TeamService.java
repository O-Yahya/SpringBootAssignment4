package com.orange.assignment4.service;

import com.orange.assignment4.DTO.TeamDTO;
import com.orange.assignment4.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    TeamDTO createTeam (TeamDTO myTeam);
    TeamDTO updateTeam(TeamDTO myTeam, Long id);
}
