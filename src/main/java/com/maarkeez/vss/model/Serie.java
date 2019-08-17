package com.maarkeez.vss.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    private String name;
    private String folderName;
    private boolean hasDisplayImageUrl;
    private String displayImageUrl;
    @Singular
    private List<Season> seasons;
}
