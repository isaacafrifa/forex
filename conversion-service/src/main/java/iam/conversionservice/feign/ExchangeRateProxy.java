package iam.conversionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange-rate-service", configuration = FeignConfiguration.class)
public interface ExchangeRateProxy {

    @GetMapping("/api/exchange-rate/from/{from}/to/{to}")
    public ExchangeRate getExchangeRateValueFromExternal(@PathVariable String from, @PathVariable String to);

}
