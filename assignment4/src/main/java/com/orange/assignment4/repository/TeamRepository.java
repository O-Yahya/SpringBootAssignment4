package com.orange.assignment4.repository;

import com.orange.assignment4.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TeamRepository extends JpaRepository<Team, Long> {
}
