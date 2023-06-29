package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.entities.GameEntity;
import com.example.VideoLabo.models.Game;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.repositories.jpa.GameJpaRepository;
import com.example.VideoLabo.services.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameJpaRepository gameJpaRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Game getGame(Long gameId){
        GameEntity gameEntity = gameJpaRepo.getReferenceById(gameId);
        return modelMapper.map(gameEntity, Game.class);

    }
}
