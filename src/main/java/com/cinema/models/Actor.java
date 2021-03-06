package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
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
    /*@OneToMany(mappedBy = "actor",targetEntity = ActorFilm.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ActorFilm> actorFilms;*/

    @ManyToMany
    @JoinTable(name = "actor_film",
                joinColumns = @JoinColumn(name = "id_Actor",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "id_Film",referencedColumnName = "id"))
    private Set<Film> films = new HashSet<>();

}
