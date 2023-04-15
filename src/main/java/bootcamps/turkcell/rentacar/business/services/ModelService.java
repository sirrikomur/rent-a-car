package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.model.create.CreateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.model.update.UpdateModelRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.create.CreateModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetAllModelsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.get.GetModelResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.model.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(int id);
    CreateModelResponse create(CreateModelRequest modelRequest);
    UpdateModelResponse update(int id, UpdateModelRequest modelRequest);
    void delete(int id);
}
