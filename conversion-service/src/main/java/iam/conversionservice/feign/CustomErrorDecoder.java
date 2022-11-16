package iam.conversionservice.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import iam.conversionservice.exception.ResourceNotFound;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        return switch (response.status()) {
            case 404 -> new ResourceNotFound("Resource Not Found");
            default -> new Exception("Generic error");
        };
    }
}
