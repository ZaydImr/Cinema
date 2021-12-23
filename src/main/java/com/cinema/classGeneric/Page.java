package com.cinema.classGeneric;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    private List<T> list;
    private Boolean next;
    private Boolean prev;

}
