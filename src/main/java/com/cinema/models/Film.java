package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="film")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Film implements Serializable {
    @Id
    @Column(name = "idFilm")
    private UUID idFilm;
    @Column(name = "titleFilm")
    private String titleFilm;
    @Column(name = "descriptionFilm")
    private String descriptionFilm;
    @Column(name = "dateRelease")
    private LocalDate dateRelease;
    @Column(name = "durationFilm")
    private LocalTime durationFilm;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeFilm")
    @Column(name = "idTypeFilm")
    private FilmType filmType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idActor")
    @Column(name = "idActor")
    private Actor actor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLanguage")
    @Column(name = "idLanguage")
    private Language language;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDirector")
    @Column(name = "idDirector")
    private Director director;
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER,targetEntity = Comment.class)
    private Set<Comment> comments;
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER,targetEntity = FilmImage.class)
    private Set<FilmImage> filmImages;
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER,targetEntity = ActorFilm.class)
    private Set<ActorFilm> actorFilms;
    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER,targetEntity = Session.class)
    private Set<Session> sessions;
}
