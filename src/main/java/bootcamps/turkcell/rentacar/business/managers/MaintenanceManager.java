package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.create.CreateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.update.UpdateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.create.CreateMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetAllMaintenancesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.update.UpdateMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import bootcamps.turkcell.rentacar.business.services.CarService;
import bootcamps.turkcell.rentacar.business.services.MaintenanceService;
import bootcamps.turkcell.rentacar.domain.entities.Maintenance;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final MaintenanceBusinessRules rules;
    private final ModelMapperService mapper;
    private final CarService carService;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        return maintenances.stream().map(maintenance -> mapper.forResponse().map(maintenance, GetAllMaintenancesResponse.class)).toList();
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        Maintenance maintenance = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(maintenance, GetMaintenanceResponse.class);
    }

    @Override
    public GetMaintenanceResponse finishMaintenance(int carId) {
        rules.carCannotBeFinishedWhenNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findByCarIdAndEndDateNull(carId);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeState(carId, CarState.AVAILABLE);
        return mapper.forResponse().map(maintenance, GetMaintenanceResponse.class);
    }

    @Override
    public CreateMaintenanceResponse create(CreateMaintenanceRequest maintenanceRequest) {
        rules.carCannotBePutUnderMaintenanceWhenUnderMaintenance(maintenanceRequest.getCarId());
        rules.carCannotBePutUnderMaintenanceWhenNotAvailable(maintenanceRequest.getCarId());
        Maintenance maintenance = mapper.forRequest().map(maintenanceRequest, Maintenance.class);
        maintenance.setId(0);
        maintenance.setStartDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeState(maintenanceRequest.getCarId(), CarState.MAINTENANCE);
        return mapper.forResponse().map(maintenance, CreateMaintenanceResponse.class);
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest maintenanceRequest) {
        Maintenance maintenance = mapper.forRequest().map(maintenanceRequest, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);
        return mapper.forResponse().map(maintenance, UpdateMaintenanceResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
