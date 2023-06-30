package com.example.VideoLabo.repositories.jpa;

import com.example.VideoLabo.entities.MatchEntity;
import com.example.VideoLabo.entities.MatchRpsEntity;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.rps.MatchRps;

public class MatchEntityFactory {
    public static Class<? extends MatchEntity> getTypeOfMatch(Match match){
        switch (match.getGame().getCode()){
            case "RPS": return MatchRpsEntity.class;
            default:return MatchRpsEntity.class;
        }
    }

}
