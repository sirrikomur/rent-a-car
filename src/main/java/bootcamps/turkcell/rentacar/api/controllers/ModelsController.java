package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.model.create.CreateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.model.update.UpdateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.create.CreateModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetAllModelsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.update.UpdateModelResponse;
import bootcamps.turkcell.rentacar.business.services.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id) {
        return modelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse create(@RequestBody CreateModelRequest modelRequest) {
        return modelService.create(modelRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest modelRequest) {
        return modelService.update(id, modelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }
}
