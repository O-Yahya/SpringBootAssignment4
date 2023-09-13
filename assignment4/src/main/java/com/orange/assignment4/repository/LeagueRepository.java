package com.orange.assignment4.repository;

import com.orange.assignment4.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LeagueRepository extends JpaRepository<League, Long> {
}
