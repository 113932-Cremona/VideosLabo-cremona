package com.example.VideoLabo.services;

import com.example.VideoLabo.models.rps.MatchRps;
import com.example.VideoLabo.models.rps.PlayRps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayStrategyFactory {


    @Autowired
    private PlayMatch<PlayRps, MatchRps> playMatchRps;

    public PlayMatch getPlayStrategy(String codeGame){

        switch (codeGame){
            case "RPS": return playMatchRps;
            default: return playMatchRps;
        }

    }
}
