package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.create.CreateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.maintenance.update.UpdateMaintenanceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.create.CreateMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetAllMaintenancesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.get.GetMaintenanceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenancesResponse> getAll();
    GetMaintenanceResponse getById(int id);
    GetMaintenanceResponse returnCarFromMaintenance(int carId);
    CreateMaintenanceResponse create(CreateMaintenanceRequest maintenanceRequest);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest maintenanceRequest);
    void delete(int id);
}
