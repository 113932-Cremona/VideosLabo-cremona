package com.example.VideoLabo.controllers;

import com.example.VideoLabo.dtos.match.MatchDTO;
import com.example.VideoLabo.models.Match;
import com.example.VideoLabo.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchservice;

    @PostMapping("")
    public ResponseEntity<Match> saveMatch(@RequestBody @Valid MatchDTO matchDTO){
        Match matchSaved = matchservice.createMatch(matchDTO);
        if(matchSaved == null){
            throw new EntityNotFoundException("andá");
        }
        else {
            return ResponseEntity.ok(matchSaved);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(@PathVariable Long id){
        return ResponseEntity.ok(matchservice.getMatchById(id));
    }
}
