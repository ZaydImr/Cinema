package com.cinema.models;

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
public class FilmType implements Serializable {
    @Id
    @Column(name = "idTypeFilm")
    private UUID idTypeFilm;
    @Column(name = "typeFilm")
    private String typeFilm;
    @OneToMany(mappedBy = "filmType",fetch = FetchType.EAGER,targetEntity = Film.class)
    private Set<Film> films;
}
