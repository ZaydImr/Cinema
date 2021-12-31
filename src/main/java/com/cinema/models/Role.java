package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@ToString
public class Role extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "role")
    private String role ;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.REMOVE)
    private Set<User> users ;

}
