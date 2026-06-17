package pe.edu.upc.center.jameoFit.profiles.domain.services;

import pe.edu.upc.center.jameoFit.profiles.domain.model.aggregates.Profile;
import pe.edu.upc.center.jameoFit.profiles.domain.model.commands.CreateProfileCommand;

public interface ProfileCommandService {
    Profile handle(CreateProfileCommand command);
}
