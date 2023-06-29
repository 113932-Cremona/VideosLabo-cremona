package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.rps.MatchRps;

public class MatchFactory {

    public static final Match createMatch(String gameCode){

        switch (gameCode){
            case "RPC": return new MatchRps(); //se podria implementar un enumerador si hubiera más juegos
            default: return new MatchRps();
        }
    }
}
