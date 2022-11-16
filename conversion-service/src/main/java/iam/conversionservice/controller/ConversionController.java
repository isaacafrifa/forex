package iam.conversionservice.controller;

import iam.conversionservice.entity.Conversion;
import iam.conversionservice.feign.ExchangeRateProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public record ConversionController(ExchangeRateProxy exchangeRateProxy) {

    @GetMapping("/conversion/from/{from}/to/{to}/amount/{amount}")
    public Conversion retrieveCurrencyConversion(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal amount) {
        var response = exchangeRateProxy.getExchangeRateValueFromExternal(from, to);
        return new Conversion(response.id(), response.from(),
                response.to(), amount,
                response.rate(),
                amount.multiply(response.rate()),
                response.environment());
    }

}
