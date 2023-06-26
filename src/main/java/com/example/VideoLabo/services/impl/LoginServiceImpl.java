package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.dtos.login.Credential;
import com.example.VideoLabo.dtos.login.EmailIdentity;
import com.example.VideoLabo.dtos.login.UserNameIdentity;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.services.LoginService;
import com.example.VideoLabo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PlayerService playerService;

    @Override
    public Player login(Credential credential){
        if(credential.getIdentity() instanceof UserNameIdentity){
            return loginWithIdentity((UserNameIdentity) credential.getIdentity(),credential.getPassword());
        }
        else {
            return loginWithIdentity((EmailIdentity) credential.getIdentity(),credential.getPassword());
        }
    }

    private Player loginWithIdentity (UserNameIdentity userNameIdentity, String password){
        return playerService.getPlayerByUserNameAndPassword(userNameIdentity.getUserName(), password);

    }
    private Player loginWithIdentity (EmailIdentity emailIdentity, String password){
        return playerService.getPlayerByEmailAndPassword(emailIdentity.getEmail(), password);

    }
}
