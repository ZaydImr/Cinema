package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Actor")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Actor implements Serializable {
    @Id
    @Column(name = "idActor")
    private UUID idActor;
    @Column(name = "fullNameActor")
    private String fullNameActor;
    @Column(name = "birthdayActor")
    private LocalDate birthdayActor;
    @Column(name = "nationalityActor")
    private String nationalityActor;
    @Column(name = "imgActor")
    private String imgActor;
    @OneToMany(mappedBy = "actor",fetch = FetchType.EAGER,targetEntity = ActorFilm.class)
    private Set<ActorFilm> actorFilms;
}
