package com.maarkeez.vss.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Season {
    @Singular
    private List<Episode> episodes;
}
