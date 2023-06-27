package com.example.VideoLabo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String code;

    @Column
    private String name;

    @Lob
    @Column
    private String description;

    @Lob
    @Column
    private String rules;


}
