package iam.exchangerateservice.controller;

import iam.exchangerateservice.entity.ExchangeRate;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public record ExchangeRateController(Environment environment) {


    @GetMapping("/exchange-rate/from/{from}/to/{to}")
    public ExchangeRate getExchangeRate(@PathVariable String from, @PathVariable String to) {
        ExchangeRate exchangeRate = new ExchangeRate(100L, from, to, BigDecimal.valueOf(13.5));
        String port = environment.getProperty("local.server.port");
        exchangeRate.setEnvironment(port);
        return exchangeRate;
    }

}
