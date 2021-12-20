package com.cinema.classGeneric;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
