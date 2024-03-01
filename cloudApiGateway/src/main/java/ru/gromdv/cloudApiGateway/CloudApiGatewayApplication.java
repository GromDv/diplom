package ru.gromdv.cloudApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("taskmanager-ms",r->r.path("/tasks/**")
						.uri("http://localhost:8087/"))
//				.route("web-service",r->r.path("/tm/**")
//						.uri("http://localhost:8086/"))
				.route("message-service-ms",r->r.path("/messages/**")
						.uri("http://localhost:8088/")).build();}

}
