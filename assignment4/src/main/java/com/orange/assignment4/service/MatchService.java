package com.orange.assignment4.service;

import com.orange.assignment4.DTO.MatchDTO;
import com.orange.assignment4.DTO.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {
    ResultDTO createMatch(MatchDTO myMatch);
}
