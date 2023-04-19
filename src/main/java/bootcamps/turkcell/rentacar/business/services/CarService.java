package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.car.create.CreateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.car.update.UpdateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.create.CreateCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetAllCarsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.update.UpdateCarResponse;
import bootcamps.turkcell.rentacar.domain.enums.CarState;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(int id);
    CreateCarResponse create(CreateCarRequest carRequest);
    UpdateCarResponse update(int id, UpdateCarRequest carRequest);
    void delete(int id);

    void changeState(int id, CarState state);
}
