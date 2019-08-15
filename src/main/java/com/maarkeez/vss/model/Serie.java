package com.maarkeez.vss.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    private String name;
    private String folderName;
    private boolean hasDisplayImageUrl;
    private String displayImageUrl;
}
