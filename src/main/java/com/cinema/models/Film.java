package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Column(name = "imgFilm")
    private String imgFilm;
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

    @OneToMany(mappedBy = "film",targetEntity = Comment.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Comment> comments;
    @OneToMany(mappedBy = "film",targetEntity = FilmImage.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<FilmImage> filmImages;
    /*@OneToMany(mappedBy = "film",targetEntity = ActorFilm.class,cascade = CascadeType.REMOVE)
    private Set<ActorFilm> actorFilms;*/
    @OneToMany(mappedBy = "film",targetEntity = Session.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Session> sessions;
    @OneToMany(mappedBy = "film",targetEntity = Events.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Events> events;

    @ManyToMany(mappedBy = "films")
    private Set<Actor> actors;
}
