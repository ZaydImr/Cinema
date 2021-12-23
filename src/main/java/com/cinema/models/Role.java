package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Role")
//@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "role")
    private String role ;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users ;

}
