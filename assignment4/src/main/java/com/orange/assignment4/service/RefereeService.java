package com.orange.assignment4.service;

import com.orange.assignment4.DTO.RefereeDTO;
import org.springframework.stereotype.Service;

import java.sql.Ref;

@Service
public interface RefereeService {

    RefereeDTO createReferee(RefereeDTO myReferee);
    RefereeDTO updateReferee(RefereeDTO myReferee, Long id);
}
