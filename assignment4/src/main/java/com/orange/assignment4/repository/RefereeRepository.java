package com.orange.assignment4.repository;

import com.orange.assignment4.entity.Referee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RefereeRepository extends JpaRepository<Referee, Long> {
}
