package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.create.CreateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.create.UpdateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.create.CreateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.create.UpdateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetAllBrandsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetBrandResponse;
import bootcamps.turkcell.rentacar.business.services.BrandService;
import bootcamps.turkcell.rentacar.domain.entities.Brand;
import bootcamps.turkcell.rentacar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public CreateBrandResponse create(CreateBrandRequest brandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(brandRequest, Brand.class);
        this.brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand, CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest brandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(brandRequest, Brand.class);
        this.brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
    }


    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
