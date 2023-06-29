package com.example.VideoLabo.entities;

import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.models.rps.ShapeHand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plays_rps")
public class PlayRpsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_rps_id")
    private MatchRpsEntity matchRps;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer1;
    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;

}
