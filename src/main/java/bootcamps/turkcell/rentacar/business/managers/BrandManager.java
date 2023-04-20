package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.create.CreateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.update.UpdateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.create.CreateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetAllBrandsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.update.UpdateBrandResponse;
import bootcamps.turkcell.rentacar.business.rules.BrandBusinessRules;
import bootcamps.turkcell.rentacar.business.services.BrandService;
import bootcamps.turkcell.rentacar.domain.entities.Brand;
import bootcamps.turkcell.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final BrandBusinessRules rules;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        return brands.stream()
                .map(brand -> mapper.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public CreateBrandResponse create(CreateBrandRequest brandRequest) {
        rules.brandNameCannotBeRepeated(brandRequest.getName());
        Brand brand = mapper.forRequest().map(brandRequest, Brand.class);
        brand.setId(0);
        repository.save(brand);
        return mapper.forResponse().map(brand, CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest brandRequest) {
        Brand brand = mapper.forRequest().map(brandRequest, Brand.class);
        brand.setId(id);
        repository.save(brand);
        return mapper.forResponse().map(brand, UpdateBrandResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }


}
