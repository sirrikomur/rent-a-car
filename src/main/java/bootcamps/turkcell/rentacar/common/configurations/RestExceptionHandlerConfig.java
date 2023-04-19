package bootcamps.turkcell.rentacar.common.configurations;

import bootcamps.turkcell.core.configurations.exceptions.RestExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestExceptionHandlerConfig {
    @Bean
    public RestExceptionHandler getRestExceptionHandler() {
        return new RestExceptionHandler();
    }
}
