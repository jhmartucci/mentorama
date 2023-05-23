package br.com.mentorama.ex10.movies.Configs;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class JMSErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable throwable) {
        System.out.println("Error accessing " + throwable.getMessage());
    }
}
