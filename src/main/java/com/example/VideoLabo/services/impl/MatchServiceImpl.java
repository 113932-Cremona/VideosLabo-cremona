package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.dtos.match.MatchDTO;
import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.models.Game;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.MatchStatus;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.models.rps.MatchRps;
import com.example.VideoLabo.repositories.jpa.MatchJpaRepository;
import com.example.VideoLabo.services.GameService;
import com.example.VideoLabo.services.MatchFactory;
import com.example.VideoLabo.services.MatchService;
import com.example.VideoLabo.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {


    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;


    @Override
    public List<Match> getMatchsByPlayer(Long playerId) {
        List<Match> matches = new ArrayList<>();

        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayerId(playerId);
        if(optionalMatchEntities.isPresent()){
            for (MatchEntity me : optionalMatchEntities.get()){
                matches.add(modelMapper.map(me,MatchFactory.createMatch(me.getGame().getCode()).getClass()));
            }

        }

        return matches;
    }
    @Override
    public Match createMatch(MatchDTO matchDTO){

        Player player = playerService.playerByID(matchDTO.getPlayer());
        Game game = gameService.getGame(matchDTO.getGame());
        Match match = MatchFactory.createMatch(game.getCode());
        match.setPlayer(player);
        match.setGame(game);
        match.setCreatedDate(LocalDateTime.now());
        match.setStatus(MatchStatus.STARTED);

        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match,MatchEntity.class));

        return modelMapper.map(matchEntity,match.getClass());

    }
}
