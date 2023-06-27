package com.example.VideoLabo.controllers;

import com.example.VideoLabo.dtos.common.ErrorApi;
import com.example.VideoLabo.dtos.login.Credential;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.services.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Operation(
            summary = "login a player in the plataform",
            description = "Return the player logged in if the credentials are corrrect"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Sucessful Operation", content = @Content(schema = @Schema(implementation = Player.class))),
                    @ApiResponse(responseCode = "404",description = "the credentials are invalid", content = @Content(schema = @Schema(implementation = ErrorApi.class))),
                    @ApiResponse(responseCode = "500",description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorApi.class))),

            }
    )

    @PostMapping("/enter")
    public ResponseEntity<Player> loginPlayer(@RequestBody @Valid Credential credential){
        System.out.println(credential);
        return ResponseEntity.ok(loginService.login(credential));
    }
}
