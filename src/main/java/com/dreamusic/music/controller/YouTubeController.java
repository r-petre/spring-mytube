package com.dreamusic.music.controller;

import com.dreamusic.music.service.YouTubeService;
import com.google.api.services.youtube.model.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/youtube")
public class YouTubeController {

	private YouTubeService youTubeService;

	public YouTubeController(YouTubeService youTubeService) {
		this.youTubeService = youTubeService;
	}

	@GetMapping("hello")
	public String hello() {
		return "Hello, World!";
	}

	@GetMapping("/video/{videoId}")
	public Video getVideoDetails(@PathVariable String videoId) throws IOException {
		return youTubeService.getVideoDetails(videoId);
	}
}
