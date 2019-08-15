package com.maarkeez.vss.api;

import com.maarkeez.vss.model.Serie;
import com.maarkeez.vss.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SerieController {

    private final SerieService serieService;

    @ResponseBody
    @GetMapping("vss/api/serie")
    public List<Serie> findAllSeries() {
        return serieService.findAll();
    }
}
