package iam.limitsservice.controller;

import iam.limitsservice.config.LimitsProperties;
import iam.limitsservice.entity.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public record LimitsController(LimitsProperties limitsProperties) {


    @GetMapping("/limits")
    public Limits getAllLimits(){
        return new Limits(limitsProperties().getMinimum(), limitsProperties().getMaximum());
    }
}
