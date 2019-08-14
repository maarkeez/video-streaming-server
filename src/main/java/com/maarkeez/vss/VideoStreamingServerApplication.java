package com.maarkeez.vss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class VideoStreamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamingServerApplication.class, args);
	}

}
