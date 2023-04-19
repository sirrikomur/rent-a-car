package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.model.create.CreateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.model.update.UpdateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.create.CreateModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetAllModelsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.update.UpdateModelResponse;
import bootcamps.turkcell.rentacar.business.services.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService service;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse create(@Valid @RequestBody CreateModelRequest modelRequest) {
        return service.create(modelRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateModelResponse update(@PathVariable int id, @Valid @RequestBody UpdateModelRequest modelRequest) {
        return service.update(id, modelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
