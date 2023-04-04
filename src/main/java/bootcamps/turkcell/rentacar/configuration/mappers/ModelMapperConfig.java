package bootcamps.turkcell.rentacar.configuration.mappers;

import bootcamps.turkcell.core.utilities.mappers.managers.ModelMapperManager;
import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapperService getModelMapperService() {
        return new ModelMapperManager(new ModelMapper());
    }
}
