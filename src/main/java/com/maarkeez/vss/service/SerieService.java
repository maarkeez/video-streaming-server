package com.maarkeez.vss.service;

import com.maarkeez.vss.model.Serie;
import com.maarkeez.vss.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SerieService {

    private final Resource folderStatic = new ClassPathResource("static");

    private final String FOLDER_SERIE = "serie";
    private final String FILE_DISPLAY_IMAGE = "displayImage.jpg";

    private final SerieRepository serieRepository;

    public List<Serie> findAll() {
        List<Serie> series = serieRepository.findAll();
        series.forEach(this::setDisplayImageUrl);
        return series;
    }

    @SneakyThrows
    private void setDisplayImageUrl(Serie serie) {

        Path serieDisplayImagePath = Paths.get(FOLDER_SERIE, serie.getFolderName(), FILE_DISPLAY_IMAGE);
        serie.setDisplayImageUrl(serieDisplayImagePath.toString());
        serie.setHasDisplayImageUrl(folderStatic.getFile().toPath().resolve(serieDisplayImagePath).toFile().exists());
    }

}
