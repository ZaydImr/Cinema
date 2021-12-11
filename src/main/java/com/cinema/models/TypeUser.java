package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="typeuser")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TypeUser implements Serializable {
    @Id
    @Column(name = "idTypeUser")
    private UUID idTypeUser ;
    @Column(name = "typeUser")
    private String typeUser ;
    @OneToMany(mappedBy = "typeUser",fetch = FetchType.EAGER,targetEntity = User.class)
    private Set<User> users ;

}
