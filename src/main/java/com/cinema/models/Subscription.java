package com.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="subscription")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subscription implements Serializable {
    @Id
    @Column(name = "idEmailSubscription")
    private UUID idEmailSubscription;
    @Column(name = "emailSubscriver")
    private String emailSubscriver;
}
