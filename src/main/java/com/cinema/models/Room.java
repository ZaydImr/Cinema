package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="room")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Room implements Serializable {
    @Id
    @Column(name = "idRoom")
    private UUID idRoom;
    @Column(name = "nameRoom")
    private String nameRoom;
    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER,targetEntity = Session.class)
    private Set<Session> sessions;
}
