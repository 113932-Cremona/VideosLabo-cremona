package com.example.VideoLabo.repositories.jpa;

import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity,Long> {


    @Query( value = "SELECT m FROM MatchEntity m WHERE m.player.id = :playerId")
    Optional<List<MatchEntity>> getAllByPlayerId(Long playerId);
}
