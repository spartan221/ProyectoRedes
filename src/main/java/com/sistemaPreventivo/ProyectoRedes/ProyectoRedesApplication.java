package com.sistemaPreventivo.ProyectoRedes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;

@SpringBootApplication
public class ProyectoRedesApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRedesApplication.class, args);
	}


}
