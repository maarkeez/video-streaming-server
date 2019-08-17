package com.maarkeez.vss.service;

import com.maarkeez.vss.model.Season;
import com.maarkeez.vss.model.Serie;
import com.maarkeez.vss.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SerieService {

    private final Path folderStatic = Paths.get("static");

    private final String FOLDER_SERIE = "serie";
    private final String FILE_DISPLAY_IMAGE = "displayImage.jpg";

    private final SerieRepository serieRepository;

    public List<Serie> findAll() {
        log.info("Main path: {}", Paths.get("").toAbsolutePath().toString());
        List<Serie> series = serieRepository.findAll();
        series.forEach(this::setDisplayImageUrl);
        series.forEach(this::setEpisodesVideoLink);
        return series;
    }

    @SneakyThrows
    private void setDisplayImageUrl(Serie serie) {

        Path serieDisplayImagePath = Paths.get(FOLDER_SERIE, serie.getFolderName(), FILE_DISPLAY_IMAGE);
        serie.setDisplayImageUrl(serieDisplayImagePath.toString());
        serie.setHasDisplayImageUrl(folderStatic.resolve(serieDisplayImagePath).toFile().exists());
    }

    @SneakyThrows
    private void setEpisodesVideoLink(Serie serie) {

        Path minionsLink = Paths.get("videos", "minions_bomberos.mp4");
        for (Season season : serie.getSeasons()) {
            for (int episodeIndex = 0; episodeIndex < season.getEpisodes().size(); episodeIndex++) {
                season.getEpisodes().get(episodeIndex).setVideoLink(minionsLink.toString());
            }
        }

    }


}
