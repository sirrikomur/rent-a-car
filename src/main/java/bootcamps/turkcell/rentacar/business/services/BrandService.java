package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.brand.create.CreateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.update.UpdateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.create.CreateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.update.UpdateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetAllBrandsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetBrandResponse getById(int id);

    CreateBrandResponse create(CreateBrandRequest brandRequest);

    UpdateBrandResponse update(int id, UpdateBrandRequest brandRequest);

    void delete(int id);
}
