package com.example.VideoLabo.services;

import com.example.VideoLabo.dtos.login.Credential;
import com.example.VideoLabo.models.Player;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Player login(Credential credential);

    //Player updateLastLogin(Player player);
}
