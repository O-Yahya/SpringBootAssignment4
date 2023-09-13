package com.orange.assignment4.repository;

import com.orange.assignment4.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
