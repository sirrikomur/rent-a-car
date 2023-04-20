package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.rental.create.CreateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.update.UpdateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.create.CreateRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetAllRentalsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.update.UpdateRentalResponse;
import bootcamps.turkcell.rentacar.business.services.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private final RentalService service;

    @GetMapping
    public List<GetAllRentalsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateRentalResponse create(@RequestBody CreateRentalRequest rentalRequest) {
        return service.create(rentalRequest);
    }

    @PutMapping("/{id}")
    public UpdateRentalResponse update(@PathVariable int id, @RequestBody UpdateRentalRequest rentalRequest) {
        return service.update(id, rentalRequest);
    }

    @PutMapping("/finish")
    public GetRentalResponse finishRental(@RequestParam int carId) {
        return service.finishRental(carId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


}
