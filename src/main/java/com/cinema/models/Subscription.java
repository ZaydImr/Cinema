package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Subscription")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subscription extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "emailSubscriber")
    private String emailSubscriber;
}
