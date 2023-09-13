package com.orange.assignment4.DTO;

import com.orange.assignment4.entity.League;
import com.orange.assignment4.entity.Player;
import com.orange.assignment4.entity.Referee;
import com.orange.assignment4.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private String league;
    private String date;
    private String referee;
    private String team1;
    private String team2;
    private String winner;
    private String result;
    private List<String> scorers = new ArrayList<>();
}
