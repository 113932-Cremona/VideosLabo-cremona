package com.example.VideoLabo.models;

import com.example.VideoLabo.models.rps.MatchRps;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.YamlProcessor;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MatchRps.class),
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Match {

    private Long id;
    private Game game;
    private Player player1;
    private Player player2;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = " dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = " dd-MM-yyyy hh:mm:ss")
    private LocalDateTime updatedAt;
    private MatchStatus status;
}
