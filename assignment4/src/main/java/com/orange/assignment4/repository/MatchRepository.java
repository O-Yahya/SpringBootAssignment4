package com.orange.assignment4.repository;

import com.orange.assignment4.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MatchRepository extends JpaRepository<Match, Long> {
}
