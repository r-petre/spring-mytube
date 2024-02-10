package com.dreamusic.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTubeApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyTubeApplication.class, args);
	}

	/*private Video getVideoDetails(String videoId) throws IOException {
		return youTubeService().getVideoDetails(videoId);
	}*/
/*
	@Bean
	public YouTubeServiceImpl youTubeService() {
		ApplicationContext context = new AnnotationConfigApplicationContext(YouTubeConfig.class);
		YouTube youTube = context.getBean("youTube", YouTube.class);
		return new YouTubeServiceImpl();
	}*/

}
