package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="actorfilm")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActorFilm implements Serializable {
    @EmbeddedId
    private Keys keys= new Keys();
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idFilm")
    @JoinColumn(name = "idFilm")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idActor")
    @JoinColumn(name = "idActor")
    private Actor actor;

}
