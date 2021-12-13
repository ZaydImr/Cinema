package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Events")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Events implements Serializable {
    @Id
    @Column(name = "idEvent")
    private UUID idEvent;
    @Column(name = "dateEvent")
    private LocalDateTime dateEvent;
    @Column(name = "dateEndEvent")
    private LocalDateTime dateEndEvent;
    @Column(name = "imgEvent")
    private String imgEvent;
    @Column(name = "titleEvent")
    private String titleEvent;
    @Column(name = "descriptionEvent")
    private String descriptionEvent;
}
