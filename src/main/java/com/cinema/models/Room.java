package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Room")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Room extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "nameRoom")
    private String nameRoom;
    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER,targetEntity = Session.class)
    private Set<Session> sessions;
}
