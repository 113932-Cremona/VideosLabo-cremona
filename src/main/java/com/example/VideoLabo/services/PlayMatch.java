package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.Play;
import org.springframework.stereotype.Service;
/*
*
* @param <P> The play response
* @param <M> the match to play
*/

@Service
public interface PlayMatch<P extends Play, M extends Match> {

    P play(P play, M match);

}
