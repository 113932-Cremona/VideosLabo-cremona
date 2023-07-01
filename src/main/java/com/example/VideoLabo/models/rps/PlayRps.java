package com.example.VideoLabo.models.rps;

import com.example.VideoLabo.models.Play;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayRps implements Play {

    private Long id;
    private Long matchRpsId;
    private ShapeHand shapeHandPlayer1;
    private ShapeHand shapeHandPlayer2;
    private Long winnerId;

}
