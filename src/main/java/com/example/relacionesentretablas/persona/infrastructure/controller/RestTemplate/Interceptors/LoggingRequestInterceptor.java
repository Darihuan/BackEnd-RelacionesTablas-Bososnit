package com.example.relacionesentretablas.persona.infrastructure.controller.RestTemplate.Interceptors;

import org.springframework.http.HttpRequest;

import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Component
public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        traceRequest(request,body);

        ClientHttpResponse response= execution.execute(request,body);

        traceResponse(response);

        return response;
    }
    private void traceRequest(HttpRequest request, byte[] body) throws IOException {

        log.error("-----------------Peticion----------------------------");
        log.debug("URI         : {}", request.getURI());
        log.debug("Metodo     : {}", request.getMethod());
        log.debug("Cabeceras   : {}", request.getHeaders());
        log.debug("Cuerpo: {}", new String(body, "UTF-8"));
        log.debug("------------------Fin de la peticion-----------------");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        log.error("--------------comienzo repuesta----------------------");


        log.debug("Estado Http  : {}", response.getStatusCode());
        log.debug("Cabeceras     : {}", response.getHeaders());
        StringBuilder body=new StringBuilder();;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
            String line = bufferedReader.readLine();
            while (line != null) {
                body.append(line);
                body.append('\n');
                line = bufferedReader.readLine();
            }
        } catch (Exception k) {
            k.printStackTrace();
        }
        log.debug("Cuerpo {}", body==null?"":body.toString());
        log.debug("--------------------------------------------------");

    }
}
