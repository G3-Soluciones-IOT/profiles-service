package pe.edu.upc.profiles_service.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.profiles_service.profiles.application.internal.outboundservices.acl.ExternalIngredientService;
import pe.edu.upc.profiles_service.profiles.domain.model.Entities.Allergy;
import pe.edu.upc.profiles_service.profiles.domain.model.valueobjects.Ingredient;
import pe.edu.upc.profiles_service.profiles.infrastructure.persistence.jpa.repositories.AllergyRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/allergies")
@Tag(name = "Allergies", description = "registras a que le tienes alergias")

public class AllergyController {
    private final AllergyRepository repository;
    private final ExternalIngredientService ingredientService;

    public AllergyController(AllergyRepository repository,
                             ExternalIngredientService ingredientService) {
        this.repository = repository;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Allergy> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Allergy create(@RequestBody Allergy allergy) {
        // Valida si existe el nombre o no
        for (Ingredient ingr : allergy.getRelatedIngredients()) {
            String name = ingr.getName();
            if (!ingredientService.existsByName(name)) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Ingrediente no registrado: " + name
                );
            }
        }
        allergy.setId(null);
        return repository.save(allergy);
    }
}
