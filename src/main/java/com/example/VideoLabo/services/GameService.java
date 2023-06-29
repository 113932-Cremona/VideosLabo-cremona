package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    Game getGame(Long game);
}
