package pe.edu.upc.center.jameoFit.shared.interfaces.rest;

import java.time.Instant;

public record ErrorResource(
        Instant timestamp,
        String message,
        String path
) {
}
