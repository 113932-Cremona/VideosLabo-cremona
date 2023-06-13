package com.example.VideoLabo;


import com.example.VideoLabo.controllers.PlayerController;
import com.example.VideoLabo.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {


    @Autowired
    private PlayerController playerController;

    @Autowired
    private PlayerService playerService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(playerController).isNotNull();
        assertThat(playerService).isNotNull();
    }
}
