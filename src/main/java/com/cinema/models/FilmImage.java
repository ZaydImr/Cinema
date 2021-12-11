package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="filmimage")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FilmImage implements Serializable {
    @Id
    @Column(name = "idImageFilm")
    private UUID idImageFilm;
    @Column(name = "imgUrl")
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilm")
    @Column(name = "idFilm")
    private Film film;
}
