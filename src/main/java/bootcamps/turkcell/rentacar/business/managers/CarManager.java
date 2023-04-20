package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.car.create.CreateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.car.update.UpdateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.create.CreateCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetAllCarsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.update.UpdateCarResponse;
import bootcamps.turkcell.rentacar.business.rules.CarBusinessRules;
import bootcamps.turkcell.rentacar.business.services.CarService;
import bootcamps.turkcell.rentacar.domain.entities.Car;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository repository;
    private final CarBusinessRules rules;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = repository.findAll();
        return cars.stream().map(car -> mapper.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(car, GetCarResponse.class);
    }

    @Override
    public CreateCarResponse create(CreateCarRequest carRequest) {
        rules.licencePlateCannotBeRepeated(carRequest.getLicensePlate());
        Car car = mapper.forRequest().map(carRequest, Car.class);
        car.setId(0);
        car.setState(CarState.AVAILABLE);
        repository.save(car);
        return mapper.forResponse().map(car, CreateCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest carRequest) {
        rules.licencePlateCannotBeRepeated(carRequest.getLicensePlate());
        Car car = mapper.forRequest().map(carRequest, Car.class);
        car.setId(id);
        repository.save(car);
        return mapper.forResponse().map(car, UpdateCarResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void changeState(int id, CarState state) {
        Car car = repository.findById(id).orElseThrow();
        car.setState(state);
        repository.save(car);
    }
}
