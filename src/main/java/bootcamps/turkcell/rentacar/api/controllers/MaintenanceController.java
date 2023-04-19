package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.create.CreateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.update.UpdateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.create.CreateMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetAllMaintenancesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.update.UpdateMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.services.MaintenanceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    private final MaintenanceService service;

    @GetMapping
    List<GetAllMaintenancesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetMaintenanceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    CreateMaintenanceResponse create(@Valid @RequestBody CreateMaintenanceRequest maintenanceRequest) {
        return service.create(maintenanceRequest);
    }

    @PutMapping("/{id}")
    UpdateMaintenanceResponse update(@PathVariable int id, @Valid @RequestBody UpdateMaintenanceRequest maintenanceRequest) {
        return service.update(id, maintenanceRequest);
    }

    @PutMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    GetMaintenanceResponse returnCarFromMaintenance(@RequestParam int carId) {
        return service.returnCarFromMaintenance(carId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


}
