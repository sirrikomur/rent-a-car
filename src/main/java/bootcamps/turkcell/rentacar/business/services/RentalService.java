package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.rental.create.CreateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.update.UpdateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.create.CreateRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetAllRentalsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();

    GetRentalResponse getById(int id);
    GetRentalResponse finishRental(int carId);
    CreateRentalResponse create(CreateRentalRequest rentalRequest);

    UpdateRentalResponse update(int id, UpdateRentalRequest rentalRequest);

    void delete(int id);
}
