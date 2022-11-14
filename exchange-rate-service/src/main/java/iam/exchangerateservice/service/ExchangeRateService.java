package iam.exchangerateservice.service;

import iam.exchangerateservice.entity.ExchangeRate;
import iam.exchangerateservice.exception.ResourceNotFound;
import iam.exchangerateservice.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

@Service
public record ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {


    public ExchangeRate getExchangeRateByFromAndTo(String from, String to){
        return exchangeRateRepository.findByFromAndTo(from, to)
                .orElseThrow(() -> new ResourceNotFound("Unable to find data for " + from + " to " + to));
    }

}
