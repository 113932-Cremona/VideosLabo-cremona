package com.example.VideoLabo.repositories.jpa;

import com.example.VideoLabo.entities.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameJpaRepository extends JpaRepository<GameEntity,Long> {

}
