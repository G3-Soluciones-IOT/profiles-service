package pe.edu.upc.profiles_service.profiles.interfaces.rest.resources;

import java.util.List;
public record UserProfileResource(
        Long id,
        String gender,
        double height,
        double weight,
        int userScore,
        String birthDate,       // âœ… debe ser String, no Long
        Long activityLevelId,
        String activityLevelName,
        Long objectiveId,
        String objectiveName,
        List<String> allergyNames
) {


    public Long getId() {
        return id;
    }
}
