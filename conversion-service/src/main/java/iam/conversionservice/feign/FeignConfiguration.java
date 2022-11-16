package iam.conversionservice.feign;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
If we want to customize one or more of these beans, we can override them by creating a Configuration class,
which we then add to the FeignClient annotation
*/
@Configuration
public class FeignConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
