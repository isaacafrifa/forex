package iam.exchangerateservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "getMessageFallback")
//    @CircuitBreaker(name = "sample-api",fallbackMethod = "getMessageFallback")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String getMessage(){
        log.info("Sample api call received");
//        var forEntity = new RestTemplate()
//                .getForEntity("http:localhost:8080/dummy-url-for-retry-test", String.class);
        return "sample-api";
    }

    public String getMessageFallback(Exception exception){
        return "This is a fallback response";
    }
}
