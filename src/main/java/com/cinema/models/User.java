package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
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
    @Column(name="reset_password_token")
    private String resetPasswordToken;
    @Column(name = "fullnameUser")
    private String fullnameUser ;
    @Column(name = "birthdayUser")
    private LocalDate birthdayUser ;
    @Column(name = "phoneNumberUser")
    private String phoneNumberUser ;
    @Column(name = "imgUser")
    private String imgUser ;

    @ManyToMany
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "id_User"),
                inverseJoinColumns = @JoinColumn(name = "id_Role"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",targetEntity = Comment.class,cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Comment> comments;

    public boolean hasRole(String roleName){
        Iterator<Role> iterator = this.roles.iterator();
        while (iterator.hasNext()){
            Role role = iterator.next();
            if(role.getRole().equals(roleName)){
                return true;
            }
        }
        return false;
    }
}
