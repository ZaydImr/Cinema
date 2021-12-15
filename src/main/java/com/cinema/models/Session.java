package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Session")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Session extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "dateBeginSession")
    private LocalDateTime dateBeginSession;
    @Column(name = "tarif")
    private double tarif;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilm")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRoom")
    private Room room;
}
