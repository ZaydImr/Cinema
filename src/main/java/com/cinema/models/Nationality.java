package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Nationality")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Nationality extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "nationality",targetEntity = Film.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Film> films;

    @OneToMany(mappedBy = "nationalityDirector",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Director> directors;

    @OneToMany(mappedBy = "nationalityActor",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Actor> actors;
}
