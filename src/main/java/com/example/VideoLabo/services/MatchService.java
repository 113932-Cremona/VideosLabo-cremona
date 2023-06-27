package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

     List<Match> getMatchsByPlayer(Long playerId);
}