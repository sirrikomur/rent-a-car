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
    private final CarService carService;

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping
    public CreateCarResponse create(@Valid @RequestBody CreateCarRequest carRequest) {
        return carService.create(carRequest);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(@PathVariable int id, @Valid @RequestBody UpdateCarRequest carRequest) {
        return carService.update(id, carRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}
