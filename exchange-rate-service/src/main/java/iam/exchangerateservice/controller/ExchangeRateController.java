package iam.exchangerateservice.controller;

import iam.exchangerateservice.entity.ExchangeRate;
import iam.exchangerateservice.service.ExchangeRateService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public record ExchangeRateController(ExchangeRateService exchangeRateService, Environment environment) {


    @GetMapping("/exchange-rate/from/{from}/to/{to}")
    public ExchangeRate getExchangeRate(@PathVariable String from, @PathVariable String to) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        exchangeRate.setEnvironment(port);
        return exchangeRate;
    }

}
