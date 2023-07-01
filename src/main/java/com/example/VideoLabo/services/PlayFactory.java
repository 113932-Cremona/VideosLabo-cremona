package com.example.VideoLabo.services;

import com.example.VideoLabo.dtos.Play.PlayRequest;
import com.example.VideoLabo.dtos.Play.PlayRpsDTO;
import com.example.VideoLabo.models.Play;
import com.example.VideoLabo.models.rps.PlayRps;

public class PlayFactory {

    public static Play getPlayInstance(PlayRequest playRequest, String gameCode){
        switch (gameCode){

            case "RPS": return getPlayRpsInstance(playRequest);
            default:return getPlayRpsInstance(playRequest);

        }

    }
    private static Play getPlayRpsInstance(PlayRequest playRequest) {
        PlayRpsDTO playRpsDTO = (PlayRpsDTO) playRequest;
        PlayRps playRps = new PlayRps();
        playRps.setShapeHandPlayer1(playRpsDTO.getShapeHandPlayer1());
        playRps.setShapeHandPlayer2(playRpsDTO.getShapeHandPlayer2());
        return playRps;
    }
}
