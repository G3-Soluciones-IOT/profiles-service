package pe.edu.upc.center.jameoFit.profiles.domain.services;

import pe.edu.upc.center.jameoFit.profiles.domain.model.aggregates.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> getAllUsers();
    Optional<Profile> getUserById(Long id);
}
