package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.dtos.Play.PlayRequest;
import com.example.VideoLabo.dtos.match.MatchDTO;
import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.models.*;
import com.example.VideoLabo.models.rps.MatchRps;
import com.example.VideoLabo.repositories.jpa.MatchEntityFactory;
import com.example.VideoLabo.repositories.jpa.MatchJpaRepository;
import com.example.VideoLabo.services.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
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
    @Autowired
    private PlayStrategyFactory playStrategyFactory;


    @Override
    public List<Match> getMatchsByPlayer(Long playerId) {
        List<Match> matches = new ArrayList<>();

        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayerId(playerId);
        if(optionalMatchEntities.isPresent()){
            for (MatchEntity me : optionalMatchEntities.get()){
                matches.add(modelMapper.map(me,MatchFactory.getTypeOfMatch(me.getGame().getCode())));
            }

        }

        return matches;
    }
    @Override
    public Match createMatch(MatchDTO matchDTO){

        Player player = playerService.playerByID(matchDTO.getPlayer());
        Game game = gameService.getGame(matchDTO.getGame());
        Match match = MatchFactory.createMatch(player,game);
//        match.setPlayer(player);
//        match.setGame(game);
//        match.setCreatedDate(LocalDateTime.now());
//        match.setStatus(MatchStatus.STARTED);

        //MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match,MatchEntity.class));
        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntityFactory.getTypeOfMatch(match)));

        return modelMapper.map(matchEntity,match.getClass());

    }


    @Override
    public Match getMatchById(Long id){

        //https://www.baeldung.com/hibernate-proxy-to-real-entity-object   documentacion de por qué jpa crea un proxy en lugar del
        //MatchEntity. tambien indica en el punto 5 como quitar el proxy
        //MatchEntity matchEntity = matchJpaRepository.getReferenceById(id);
        MatchEntity matchEntity = (MatchEntity) Hibernate.unproxy(matchJpaRepository.getReferenceById(id));
        if (matchEntity != null){
            Match match = modelMapper.map(matchEntity, MatchFactory.getTypeOfMatch(matchEntity.getGame().getCode()));
            return match;
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @Override
    public Play play(Long matchId, PlayRequest playRequest){

        Match match = this.getMatchById(matchId);

        if (match != null){
            Play play = PlayFactory.getPlayInstance(playRequest,match.getGame().getCode());
            PlayMatch playMatch = playStrategyFactory.getPlayStrategy(match.getGame().getCode());
            return playMatch.play(play,match);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
