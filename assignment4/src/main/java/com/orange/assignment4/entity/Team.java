package com.orange.assignment4.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.slf4j.helpers.LegacyAbstractLogger;

import java.util.List;

@Entity
@Table(name="teams")
@Data
public class Team {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="league_id")
    private League league;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @OneToOne(mappedBy = "team")
    private Coach coach;

    @OneToMany(mappedBy = "team2")
    private List<Match> awayMatches;

    @OneToMany(mappedBy = "team1")
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "winner")
    private List<Match> matchesWon;
}
