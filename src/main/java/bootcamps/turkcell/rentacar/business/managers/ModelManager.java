package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.model.create.CreateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.model.update.UpdateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.create.CreateModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetAllModelsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.update.UpdateModelResponse;
import bootcamps.turkcell.rentacar.business.services.ModelService;
import bootcamps.turkcell.rentacar.domain.entities.Model;
import bootcamps.turkcell.rentacar.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        return models.stream().map(model -> this.mapper.forResponse().map(model, GetAllModelsResponse.class)).toList();
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(model, GetModelResponse.class);
    }

    @Override
    public CreateModelResponse create(CreateModelRequest modelRequest) {
        Model model = mapper.forRequest().map(modelRequest, Model.class);
        repository.save(model);
        return mapper.forResponse().map(model, CreateModelResponse.class);
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest modelRequest) {
        Model model = mapper.forRequest().map(modelRequest, Model.class);
        model.setId(id);
        repository.save(model);
        return mapper.forResponse().map(model, UpdateModelResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
