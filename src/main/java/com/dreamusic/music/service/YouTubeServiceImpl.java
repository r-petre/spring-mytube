package com.dreamusic.music.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class YouTubeServiceImpl implements YouTubeService {

	private static final Logger LOG = LoggerFactory.getLogger(YouTubeServiceImpl.class);

	private final YouTube youTube;

	public YouTubeServiceImpl(YouTube youTube) {
		this.youTube = youTube;
	}

	@Override
	public Video getVideoDetails(String videoId) throws IOException {
		YouTube.Videos.List request = youTube.videos().list("snippet,contentDetails,statistics");
		VideoListResponse response = request.setId(videoId).execute();
		List<Video> videos = response.getItems();
		if (videos != null && videos.size() > 0) {
			LOG.info("{} videos found for ID {}", videos.size(), videoId);
			return videos.get(0);
		}

		return null;
	}
}
