package com.maarkeez.vss.repository;

import com.maarkeez.vss.model.Serie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SerieRepository {

    private final List<Serie> series = new ArrayList<>();

    public SerieRepository() {
        series.add(trueBlood());
    }

    public List<Serie> findAll() {
        return series;
    }

    private Serie trueBlood() {
        return Serie.builder()
                .name("True Blood")
                .folderName("trueBlood")
                .build();
    }


}
