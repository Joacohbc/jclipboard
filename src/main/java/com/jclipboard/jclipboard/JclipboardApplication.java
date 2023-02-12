package com.jclipboard.jclipboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JclipboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(JclipboardApplication.class, args);
	}

}
