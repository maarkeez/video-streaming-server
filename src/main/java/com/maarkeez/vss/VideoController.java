package com.maarkeez.vss;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.file.Files.readAllBytes;

@Service
@RestController
@RequiredArgsConstructor
public class VideoController {

    @ResponseBody
    @GetMapping("/vss/api/video/random")
    public ResponseEntity<InputStreamResource> randomVideo() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File videoFile = new File(classLoader.getResource("videos/minions_bomberos.mp4").getFile());

        byte[] videoBytes = readAllBytes(videoFile.toPath());
        InputStream videoStream = new ByteArrayInputStream(videoBytes);

        return ResponseEntity.ok()
                .contentLength(videoBytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(videoStream));
    }
}
