package com.dreamusic.music;

import com.dreamusic.music.services.YouTubeService;
import com.google.api.services.youtube.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MyTubeApplication {

	@Autowired
	private YouTubeService youTubeService;

	public static void main(String[] args) {
		SpringApplication.run(MyTubeApplication.class, args);
	}

	private Video getVideoDetails(String videoId) throws IOException {
		return youTubeService.getVideoDetails(videoId);
	}

}
