package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="director")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Language implements Serializable {
    @Id
    @Column(name = "idLanguage")
    private UUID idLanguage;
    @Column(name = "LanguageFilm")
    private String languageFilm;
    @OneToMany(mappedBy = "language",fetch = FetchType.EAGER,targetEntity = Film.class)
    private Set<Film> films;
}
