package com.orange.assignment4.repository;

import com.orange.assignment4.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
