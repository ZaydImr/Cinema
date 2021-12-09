package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="comment")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comment implements Serializable {
    @Id
    @Column(name = "idComment")
    private UUID idComment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    @Column(name = "idUser")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFilm")
    @Column(name = "idFilm")
    private Film film;
    @Column(name = "contentComment")
    private String contentComment;
}
