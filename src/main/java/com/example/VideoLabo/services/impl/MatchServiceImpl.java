package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.dtos.match.MatchDTO;
import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.models.Game;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.MatchStatus;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.models.rps.MatchRps;
import com.example.VideoLabo.repositories.jpa.MatchEntityFactory;
import com.example.VideoLabo.repositories.jpa.MatchJpaRepository;
import com.example.VideoLabo.services.GameService;
import com.example.VideoLabo.services.MatchFactory;
import com.example.VideoLabo.services.MatchService;
import com.example.VideoLabo.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
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
}
