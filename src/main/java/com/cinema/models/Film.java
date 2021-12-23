package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Film")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Film extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "titleFilm")
    private String titleFilm;
    @Column(name = "descriptionFilm")
    private String descriptionFilm;
    @Column(name = "dateRelease")
    private LocalDate dateRelease;
    @Column(name = "durationFilm")
    private LocalDateTime durationFilm;

    @ManyToOne
    @JoinColumn(name = "idTypeFilm")
    private FilmType filmType;
    @ManyToOne
    @JoinColumn(name = "idLanguage")
    private Nationality nationality;
    @ManyToOne
    @JoinColumn(name = "idDirector")
    private Director director;

    @OneToMany(mappedBy = "film",targetEntity = Comment.class)
    @JsonIgnore
    private Set<Comment> comments;
    @OneToMany(mappedBy = "film",targetEntity = FilmImage.class)
    @JsonIgnore
    private Set<FilmImage> filmImages;
    @OneToMany(mappedBy = "film",targetEntity = ActorFilm.class)
    @JsonIgnore
    private Set<ActorFilm> actorFilms;
    @OneToMany(mappedBy = "film",targetEntity = Session.class)
    @JsonIgnore
    private Set<Session> sessions;
    @OneToMany(mappedBy = "film",targetEntity = Events.class)
    @JsonIgnore
    private Set<Events> events;
}
