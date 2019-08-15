package com.maarkeez.vss.service;

import com.maarkeez.vss.model.Serie;
import com.maarkeez.vss.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SerieService {

    private final String FOLDER_SERIE = "serie";
    private final String SLASH = "/";
    private final String FILE_DISPLAY_IMAGE = "displayImage.jpg";

    private final SerieRepository serieRepository;

    public List<Serie> findAll() {
        List<Serie> series = serieRepository.findAll();
        series.forEach(this::setDisplayImageUrl);
        return series;
    }

    private void setDisplayImageUrl(Serie serie) {
        serie.setDisplayImageUrl(FOLDER_SERIE + SLASH + serie.getFolderName() + SLASH + FILE_DISPLAY_IMAGE);
    }

}
