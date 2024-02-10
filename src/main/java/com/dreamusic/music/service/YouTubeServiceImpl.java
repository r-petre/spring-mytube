package com.dreamusic.music.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class YouTubeServiceImpl implements YouTubeService {

	private static final Logger LOG = LoggerFactory.getLogger(YouTubeServiceImpl.class);

	//	@Value("${youtube.api.key}")
	private String apiKey = "AIzaSyA6y24URxlHZyPHOZF6rsD1lIOAsN10vdk";

	private final HttpTransport httpTransport;
	private final JsonFactory jsonFactory;


	public YouTubeServiceImpl() throws GeneralSecurityException, IOException {
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		jsonFactory = JacksonFactory.getDefaultInstance();
	}

	public YouTube getYouTubeClient() {
		return new YouTube.Builder(httpTransport, jsonFactory, null)
				.setApplicationName("MyTube")
				.build();
	}

	@Override
	public Video getVideoDetails(String videoId) throws IOException {
		LOG.info("Get video details for videoID={}", videoId);
		YouTube.Videos.List request = getYouTubeClient().videos().list("snippet,contentDetails,statistics");
		request.setKey(apiKey);
		VideoListResponse response = request.setId(videoId).execute();
		List<Video> videos = response.getItems();
		if (videos != null && !videos.isEmpty()) {
			LOG.info("{} videos found for ID {}", videos.size(), videoId);
			return videos.get(0);
		}

		return null;
	}
}
