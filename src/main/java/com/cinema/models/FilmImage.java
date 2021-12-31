package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="FilmImage")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FilmImage extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "imgUrl")
    private String imageUrl;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idFilm")
    private Film film;
}
