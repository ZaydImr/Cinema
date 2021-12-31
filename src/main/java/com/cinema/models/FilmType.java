package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="FilmType")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FilmType extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "typeFilm")
    private String typeFilm;
    @OneToMany(mappedBy = "filmType",targetEntity = Film.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Film> films;
}
