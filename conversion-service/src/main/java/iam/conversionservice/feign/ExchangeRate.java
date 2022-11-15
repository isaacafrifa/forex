package iam.conversionservice.feign;

import java.math.BigDecimal;

/* This class acts like a Feign object to mimic ExchangeRate from the exchange-rate-service
 */
public record ExchangeRate(Long id, String from, String to, BigDecimal rate, String environment) {
}
