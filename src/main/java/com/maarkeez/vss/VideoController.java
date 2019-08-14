package com.maarkeez.vss;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequiredArgsConstructor
public class VideoController {

    @ResponseBody
    @GetMapping("/vss/api/ping")
    public ResponseEntity<String> randomVideo() {

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body("Pong");
    }
}
