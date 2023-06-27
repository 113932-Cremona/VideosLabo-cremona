package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.MatchStatus;
import com.example.VideoLabo.repositories.jpa.MatchJpaRepository;
import com.example.VideoLabo.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {


    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Match> getMatchsByPlayer(Long playerId) {
        List<Match> matches = new ArrayList<>();

        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayerId(playerId);
        if(optionalMatchEntities.isPresent()){
            for (MatchEntity me : optionalMatchEntities.get()){
                matches.add(modelMapper.map(me,Match.class));
            }

        }
        return matches;
    }
}
