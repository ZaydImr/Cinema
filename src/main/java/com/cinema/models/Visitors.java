package com.cinema.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Room")
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Visitors extends AbstractModel<UUID> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "data")
    private String data;
    @Column(name = "dateVisit")
    private LocalDate dateVisit;
}
