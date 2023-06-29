package com.example.VideoLabo.entities;

import com.example.VideoLabo.models.MatchStatus;
import com.example.VideoLabo.models.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matches")
@Inheritance (strategy = InheritanceType.JOINED)
public class MatchEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "game_id")
    @ManyToOne
    private GameEntity game;

    @JoinColumn(name = "player_id")
    @ManyToOne
    private PlayerEntity player;

    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

}
