package ru.gromdv.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebServiceApplication {

//	@Bean
//	public ModelMapper modelMapper() {
//		return  new ModelMapper();
//	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	};

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}
	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}
