package com.maarkeez.vss.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PingController {

    @ResponseBody
    @GetMapping("/vss/api/ping")
    public ResponseEntity<String> ping() {

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body("Pong");
    }

}
