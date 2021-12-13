package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="User")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @Column(name = "idUser")
    private UUID idUser ;
    @Column(name = "email")
    private String email ;
    @Column(name = "password")
    private String password ;
    @Column(name = "fullnameUser")
    private String fullnameUser ;
    @Column(name = "birthdayUser")
    private LocalDate birthdayUser ;
    @Column(name = "phoneNumberUser")
    private String phoneNumberUser ;
    @Column(name = "imgUser")
    private String imgUser ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeUser")
    private TypeUser typeUser ;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,targetEntity = Comment.class)
    private Set<Comment> comments;
}
