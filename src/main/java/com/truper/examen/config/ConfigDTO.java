package com.truper.examen.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDTO {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
