package com.example.VideoLabo.services;

import com.example.VideoLabo.dtos.Play.PlayRequest;
import com.example.VideoLabo.dtos.match.MatchDTO;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.Play;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

     List<Match> getMatchsByPlayer(Long playerId);

     Match createMatch(MatchDTO matchDTO);

     Match getMatchById(Long id);

     Play play (Long matchId, PlayRequest play);
}
