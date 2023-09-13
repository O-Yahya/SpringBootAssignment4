package com.orange.assignment4.service;

import com.orange.assignment4.DTO.CoachDTO;
import com.orange.assignment4.DTO.PlayerDTO;
import org.springframework.stereotype.Service;

@Service
public interface CoachService {

    CoachDTO createCoach(CoachDTO myCoach);
    CoachDTO updateCoach(CoachDTO myCoach, Long id);
}