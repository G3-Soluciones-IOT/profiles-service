package pe.edu.upc.center.jameoFit.profiles.domain.model.commands;

import java.util.List;

public record CreateUserProfileCommand(
        Long userId,            // <-- nuevo campo
        String gender,
        double height,
        double weight,
        int userScore,
        Long activityLevelId,
        Long objectiveId,
        List<Long> allergyIds,
        String birthDate // âœ… nuevo

) { }
