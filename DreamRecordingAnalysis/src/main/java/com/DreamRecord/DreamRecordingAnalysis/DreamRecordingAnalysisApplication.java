package com.DreamRecord.DreamRecordingAnalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DreamRecordingAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamRecordingAnalysisApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello, peter";
	}

}
