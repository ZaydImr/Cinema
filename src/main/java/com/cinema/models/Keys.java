package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Keys implements Serializable {
    @Column(name = "idFilm")
    private UUID idFilm;
    @Column(name = "idActor")
    private UUID idActor;
}
