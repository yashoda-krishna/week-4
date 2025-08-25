package com.example.NoPrimarykey;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class NoPrimarykeyApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(NoPrimarykeyApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }
}