package com.dreamusic.music.controller;

import com.dreamusic.music.service.YouTubeService;
import com.google.api.services.youtube.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class YouTubeController {

	@Autowired
	private YouTubeService youTubeService;

	@GetMapping("/video/{videoId}")
	public Video getVideoDetails(@PathVariable String videoId) throws IOException {
		return youTubeService.getVideoDetails(videoId);
	}
}
