package com.dreamusic.music.service;

import com.google.api.services.youtube.model.Video;

import java.io.IOException;

public interface YouTubeService {
	Video getVideoDetails(String videoId) throws IOException;
}
