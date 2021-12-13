package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="ActorFilm")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActorFilm implements Serializable {
    @Id
    @Column(name = "idActorFilm")
    private UUID idActorFilm;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idFilm")
    @JoinColumn(name = "idFilm")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idActor")
    @JoinColumn(name = "idActor")
    private Actor actor;

}
