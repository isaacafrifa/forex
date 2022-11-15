package iam.conversionservice.controller;

import iam.conversionservice.entity.Conversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public record ConversionController() {

    @GetMapping("/conversion/from/{from}/to/{to}/amount/{amount}")
    public Conversion retrieveCurrencyConversion(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal amount) {
        return new Conversion(1000L, from, to, amount, BigDecimal.ONE, BigDecimal.ONE, "");
    }

}
