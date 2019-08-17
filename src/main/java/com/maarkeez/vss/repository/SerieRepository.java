package com.maarkeez.vss.repository;

import com.maarkeez.vss.model.Episode;
import com.maarkeez.vss.model.Season;
import com.maarkeez.vss.model.Serie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class SerieRepository {

    private final List<Serie> series = new ArrayList<>();

    public SerieRepository() {
        series.add(trueBlood());
        series.add(gameOfThrones());
        series.add(siliconValley());
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

    private Serie gameOfThrones() {
        return Serie.builder()
                .name("Game of thrones")
                .folderName("gameOfThrones")
                .seasons(asList(
                        Season.builder()
                                .episodes(asList(
                                        Episode.builder().title("Winter Is Coming").build(),
                                        Episode.builder().title("The Kingsroad").build(),
                                        Episode.builder().title("Lord Snow").build(),
                                        Episode.builder().title("Cripples, Bastards, and Broken Things").build(),
                                        Episode.builder().title("The Wolf and the Lion").build(),
                                        Episode.builder().title("A Golden Crown").build(),
                                        Episode.builder().title("You Win or You Die").build()
                                )).build(),
                        Season.builder()
                                .episodes(asList(
                                        Episode.builder().title("Winter Is Coming").build(),
                                        Episode.builder().title("The Kingsroad").build(),
                                        Episode.builder().title("Lord Snow").build(),
                                        Episode.builder().title("Cripples, Bastards, and Broken Things").build(),
                                        Episode.builder().title("The Wolf and the Lion").build(),
                                        Episode.builder().title("A Golden Crown").build(),
                                        Episode.builder().title("You Win or You Die").build()
                                )).build()
                )).build();
    }

    private Serie siliconValley() {
        return Serie.builder()
                .name("Silicon Valley")
                .folderName("siliconValley")
                .build();
    }


}
