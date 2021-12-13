package com.cinema.models;

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
public class Nationality implements Serializable {
    @Id
    @Column(name = "idNationality")
    private UUID idNationality;
    @Column(name = "nationality")
    private String nationality;
    @OneToMany(mappedBy = "nationality",fetch = FetchType.EAGER,targetEntity = Film.class)
    private Set<Film> films;
}
