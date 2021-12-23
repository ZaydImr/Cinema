package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Comment")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comment extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idFilm")
    private Film film;
    @Column(name = "contentComment")
    private String contentComment;
}
