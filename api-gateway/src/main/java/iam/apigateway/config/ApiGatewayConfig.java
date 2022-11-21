package iam.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("DummyAuth", "key123")
                                .addRequestParameter("MyParam", "myValue")
                        )
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/api/exchange-rate/**")
                        .uri("lb://exchange-rate-service")) //the "lb" stands for load balance
                .route(p -> p
                        .path("/api/conversion/**")
                        .uri("lb://conversion-service"))
                .build();
    }
}
