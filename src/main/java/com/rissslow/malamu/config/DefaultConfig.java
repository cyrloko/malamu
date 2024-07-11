package com.rissslow.malamu.config;

import com.rissslow.malamu.exception.DefaultException;
import com.rissslow.malamu.exception.DefaultExceptionMapper;
import jakarta.ws.rs.ext.ExceptionMapper;
import org.springframework.context.annotation.Bean;

public class DefaultConfig {

    @Bean
    public ExceptionMapper<DefaultException> defaultExceptionMapper() {
        return new DefaultExceptionMapper();
    }
}
