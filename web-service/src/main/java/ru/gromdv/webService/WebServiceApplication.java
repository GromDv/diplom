package ru.gromdv.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class WebServiceApplication {

//	@Bean
//	public ModelMapper modelMapper() {
//		return  new ModelMapper();
//	}

	@Bean
	public ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new Java8TimeDialect());
		engine.setTemplateResolver(templateResolver);
		return engine;
	}
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
