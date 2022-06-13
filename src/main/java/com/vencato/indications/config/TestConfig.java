package com.vencato.indications.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vencato.indications.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

		@Autowired
		private DBService dbService;

		@Bean
		public void dbInstantiate() {
			this.dbService.dbInstantiate();
		}
}
