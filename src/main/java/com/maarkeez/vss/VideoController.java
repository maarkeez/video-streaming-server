package com.maarkeez.vss;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@Service
@RestController
@RequiredArgsConstructor
public class VideoController {

    @Value("classpath:videos/minions_bomberos.mp4")
    private Resource videoFile;

    @ResponseBody
    @GetMapping("/vss/api/video/random.mp4")
    public ResponseEntity<InputStreamResource> randomVideo() throws IOException {

        InputStream videoStream = videoFile.getInputStream();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("video/mp4"))
                .body(new InputStreamResource(videoStream));
    }
}
