package pe.edu.upc.center.jameoFit.profiles.domain.model.commands;

public record UpdateUserProfileCommand(
        Long userProfileId,
        String gender,
        double height,
        double weight,
        int userScore,
        Long activityLevelId,
        Long objectiveId,
        String birthDate // âœ… nuevo
) { }
