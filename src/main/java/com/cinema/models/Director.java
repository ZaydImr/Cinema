package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Director")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Director implements Serializable {
    @Id
    @Column(name = "IdDirector")
    private UUID idDirector;
    @Column(name = "fullnameDirector")
    private String fullnameDirector;
    @Column(name = "birthdayDirector")
    private LocalDate birthdayDirector;
    @Column(name = "nationalityDirector")
    private String nationalityDirector;
    @Column(name = "imgDirector")
    private String imgDirector;
    @OneToMany(mappedBy = "director",fetch = FetchType.EAGER,targetEntity = Film.class)
    private Set<Film> films;
}
