package iam.exchangerateservice.controller;

import iam.exchangerateservice.entity.ExchangeRate;
import iam.exchangerateservice.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public record ExchangeRateController(ExchangeRateService exchangeRateService, Environment environment) {


    @GetMapping("/exchange-rate/from/{from}/to/{to}")
    public ExchangeRate getExchangeRate(@PathVariable String from, @PathVariable String to) {
        log.info("getExchangeRate called with {} to {}", from, to);
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        exchangeRate.setEnvironment(port);
        return exchangeRate;
    }

}
