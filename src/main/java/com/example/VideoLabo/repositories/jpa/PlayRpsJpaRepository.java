package com.example.VideoLabo.repositories.jpa;

import com.example.VideoLabo.entities.PlayRpsEntity;
import com.example.VideoLabo.models.rps.PlayRps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRpsJpaRepository extends JpaRepository<PlayRpsEntity, Long> {
}
