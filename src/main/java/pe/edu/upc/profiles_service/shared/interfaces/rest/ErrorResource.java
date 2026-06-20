package pe.edu.upc.profiles_service.shared.interfaces.rest;

import java.time.Instant;

public record ErrorResource(
        Instant timestamp,
        String message,
        String path
) {
}
