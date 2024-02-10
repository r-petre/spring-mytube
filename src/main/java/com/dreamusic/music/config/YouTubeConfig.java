package com.dreamusic.music.config;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YouTubeConfig {

	@Value("${youtube.api.key}")
	private String apiKey;

	@Bean
	public YouTube youTube() {
		return new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), null)
				.setApplicationName("MyTube")
				.build();
	}
}
