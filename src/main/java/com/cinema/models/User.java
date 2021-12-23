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
public class User extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;
    
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
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,targetEntity = Comment.class)
    private Set<Comment> comments;
}
