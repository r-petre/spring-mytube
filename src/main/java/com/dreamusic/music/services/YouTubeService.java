package com.dreamusic.music.services;

import com.google.api.services.youtube.model.Video;

import java.io.IOException;

public interface YouTubeService {
	Video getVideoDetails(String videoId) throws IOException;
}
