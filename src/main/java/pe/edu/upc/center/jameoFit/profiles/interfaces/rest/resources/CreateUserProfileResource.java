package pe.edu.upc.center.jameoFit.profiles.interfaces.rest.resources;

import java.util.List;

public record CreateUserProfileResource(
        Long userId,            // <-- nuevo
        String gender,
        double height,
        double weight,
        int userScore,
        Long activityLevelId,
        Long objectiveId,
        List<Long> allergyIds,
        String birthDate // âœ… nuevo

) {}
