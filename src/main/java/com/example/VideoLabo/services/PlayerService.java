package com.example.VideoLabo.services;

import com.example.VideoLabo.models.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {

    Player playerByID(Long id);

    Player savePlayer (Player player);

    Player getPlayerByUserNameAndPassword(String username, String password);
    Player getPlayerByEmailAndPassword(String email, String password);

}
