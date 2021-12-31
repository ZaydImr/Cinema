package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "room",targetEntity = Session.class,cascade = CascadeType.REMOVE)
    private Set<Session> sessions;
}
