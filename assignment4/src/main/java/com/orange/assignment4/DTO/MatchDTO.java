package com.orange.assignment4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

    private Long leagueId;
    private Long team1id;
    private Long team2id;
    private String date;
    private Long refereeId;
}
