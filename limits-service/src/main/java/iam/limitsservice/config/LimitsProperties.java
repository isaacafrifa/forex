package iam.limitsservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("limits-service")
@Getter @Setter
public class LimitsProperties {
    private int minimum;
    private int maximum;
}
