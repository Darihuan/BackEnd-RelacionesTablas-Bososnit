package com.example.relacionesentretablas.persona.infrastructure.controller.feing;

import com.example.relacionesentretablas.core.error.CustomError;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class FeingFallbackFactory implements FallbackFactory<ProfesorClient> {
    @Override
    public ProfesorClient create(Throwable cause) {
        return new FeingFallback(cause);

    }

    class FeingFallback implements ProfesorClient{
        int code;
        String msg;

        FeingFallback(Throwable cause)
        {
            if (cause instanceof FeignException)
            {
                FeignException feignException = (FeignException) cause;
                code=feignException.status();

            }
            msg=cause.getMessage();
        }

        @Override
        public ResponseEntity<?> getprofesorbyid(Integer id) {
            return ResponseEntity.status(code).body(new CustomError(new Date(),code,msg));
        }
    }
}
