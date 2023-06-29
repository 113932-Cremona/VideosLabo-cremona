package com.example.VideoLabo.controllers;

import com.example.VideoLabo.entities.PlayerEntity;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.repositories.jpa.PlayerJpaRepository;
import com.example.VideoLabo.services.MatchService;
import com.example.VideoLabo.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {


    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        Player findNotFound = playerService.playerByID(id);

        if(findNotFound.getUserName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se encontró el usuario");
        }
        else {
            return ResponseEntity.ok(findNotFound);
        }

    }

    @PostMapping("/guardar")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player){

        Player playerSaved = playerService.savePlayer(player);

        if(playerSaved == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"userName o Email ya existe");
        }
        else {
            return ResponseEntity.ok(playerSaved);
        }

    }

    @GetMapping("/{id}/matches")
    public ResponseEntity<List<Match>> getMatchesById(@PathVariable Long id){
        List<Match> matches =   matchService.getMatchsByPlayer(id);
        return ResponseEntity.ok(matches);



    }
}
