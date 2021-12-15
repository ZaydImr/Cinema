package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="TypeUser")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TypeUser extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "typeUser")
    private String typeUser ;
    @OneToMany(mappedBy = "typeUser",fetch = FetchType.EAGER,targetEntity = User.class)
    private Set<User> users ;

}
