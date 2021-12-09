package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="actorfilm")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActorFilm implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilm")
    @Column(name = "idfilm")
    private Film film;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idActor")
    @Column(name = "idActor")
    private Actor actor;

}
