package pe.edu.upc.center.jameoFit.profiles.domain.services;

import pe.edu.upc.center.jameoFit.profiles.domain.model.aggregates.UserProfile;
import pe.edu.upc.center.jameoFit.profiles.domain.model.commands.CreateUserProfileCommand;
import pe.edu.upc.center.jameoFit.profiles.domain.model.commands.DeleteUserProfileCommand;
import pe.edu.upc.center.jameoFit.profiles.domain.model.commands.UpdateUserProfileCommand;

import java.util.Optional;


public interface UserProfileCommandService {
    Long handle(CreateUserProfileCommand command);

    Optional<UserProfile> handle(UpdateUserProfileCommand command);

    void handle(DeleteUserProfileCommand command);
}
