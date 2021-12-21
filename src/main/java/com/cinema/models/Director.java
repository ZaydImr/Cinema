package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Director extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "fullnameDirector")
    private String fullnameDirector;
    @Column(name = "birthdayDirector")
    private LocalDate birthdayDirector;

    @ManyToOne
    @JoinColumn(name = "idNationalityDirector")
    private Nationality nationalityDirector;

    @Column(name = "imgDirector")
    private String imgDirector;

    @JsonIgnore
    @OneToMany(mappedBy = "director",fetch = FetchType.EAGER,targetEntity = Film.class)
    private Set<Film> films;
}
