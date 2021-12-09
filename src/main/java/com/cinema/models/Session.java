package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="session")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Session implements Serializable {
    @Id
    @Column(name = "idSession")
    private UUID idSession;
    @Column(name = "dateBeginSession")
    private LocalDateTime dateBeginSession;
    @Column(name = "tarif")
    private double tarif;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilm")
    @Column(name = "idFilm")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRoom")
    @Column(name = "idRoom")
    private Room room;
}
