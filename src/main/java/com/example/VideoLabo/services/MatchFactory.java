package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Game;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.MatchStatus;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.models.rps.MatchRps;
import com.example.VideoLabo.models.rps.PlayRps;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MatchFactory {

//    public static Match createMatch(String gameCode) {
//
//        switch (gameCode) {
//            case "RPS":
//                return new MatchRps(); //se podria implementar un enumerador si hubiera más juegos
//            default:
//                return new MatchRps();
//        }
//    }

    public static Match createMatch(Player player, Game game) {
        switch (game.getCode()) {
            case "RPS":
                return createMatchRps(player, game);
            default:
                return createMatchRps(player, game);
        }

    }


    public static Class<? extends Match> getTypeOfMatch(String gameCode){
        switch (gameCode){
            case "RPS": return MatchRps.class;
            default:return MatchRps.class;
        }
    }


    public static Match createMatchRps(Player player,Game game){
        MatchRps matchRps = (MatchRps) getBasicMatch(player,game);
        matchRps.setNumberOfPlays(10);
        matchRps.setRemainderPlays(10);
        matchRps.setPlayer1Score(0);
        matchRps.setPlayer2Score(0);
        matchRps.setPlays(new ArrayList<PlayRps>());
        return matchRps;

    }

    private static Match getBasicMatch(Player player, Game game){
        Match match = getBasicMatchInstance(game.getCode());
        match.setPlayer(player);
        match.setGame(game);
        match.setCreatedDate(LocalDateTime.now());
        match.setStatus(MatchStatus.STARTED);
        return match;
    }

    private static Match getBasicMatchInstance(String gameCode){
        switch (gameCode){
            case "RPS": return new MatchRps();
            default: return  new MatchRps();
        }
    }
}
