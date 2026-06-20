package pe.edu.upc.profiles_service.profiles.interfaces.rest.resources;

public record ProfileResource(
        Long id,
        String name,
        String email,
        String password,
        Boolean isActive,
        String birthDate,
        Long userProfileId
) {}
