package org.code.challenger.configuration;

import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.code.challenger.client.FeignClientErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }
}
