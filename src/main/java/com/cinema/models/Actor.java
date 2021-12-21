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
public class Actor extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "fullNameActor")
    private String fullNameActor;
    @Column(name = "birthdayActor")
    private LocalDate birthdayActor;
    @ManyToOne
    @JoinColumn(name = "idNationalityActor")
    private Nationality nationalityActor;

    @Column(name = "imgActor")
    private String imgActor;
    @OneToMany(mappedBy = "actor",fetch = FetchType.EAGER,targetEntity = ActorFilm.class)
    private Set<ActorFilm> actorFilms;
    

}
