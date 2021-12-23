package com.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="News")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class News extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "subject")
    private String subject;
    @Column(name = "content")
    private String content;
}
