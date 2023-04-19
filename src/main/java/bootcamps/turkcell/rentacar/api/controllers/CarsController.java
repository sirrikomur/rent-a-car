package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.car.create.CreateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.car.update.UpdateCarRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.create.CreateCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetAllCarsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.update.UpdateCarResponse;
import bootcamps.turkcell.rentacar.business.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {
    private final CarService service;

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateCarResponse create(@Valid @RequestBody CreateCarRequest carRequest) {
        return service.create(carRequest);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(@PathVariable int id, @Valid @RequestBody UpdateCarRequest carRequest) {
        return service.update(id, carRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
