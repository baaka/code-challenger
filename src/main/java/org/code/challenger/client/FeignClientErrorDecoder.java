package org.code.challenger.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.code.challenger.exception.AppException;
import org.code.challenger.util.AppConstants;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error(methodKey + " - " + response.reason());

        return new AppException(AppConstants.EXTERNAL_SERVICE_EXCEPTION);
    }
}
