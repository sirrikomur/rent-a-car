package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.brand.create.CreateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.brand.update.UpdateBrandRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.create.CreateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.update.UpdateBrandResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetAllBrandsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.brand.get.GetBrandResponse;
import bootcamps.turkcell.rentacar.business.services.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService brandService;

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse create(@Valid @RequestBody CreateBrandRequest brandRequest) {
        return brandService.create(brandRequest);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable int id,  @Valid @RequestBody UpdateBrandRequest brandRequest) {
        return brandService.update(id, brandRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

}
