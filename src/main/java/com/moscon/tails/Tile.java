package com.moscon.tails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Tile {
    private Integer x = 0;
    private Integer y = 0;
    private Integer zoom = 0;
}
