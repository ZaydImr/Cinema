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
public class ActorFilm extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idFilm")
    @JoinColumn(name = "idFilm")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idActor")
    @JoinColumn(name = "idActor")
    private Actor actor;

}
