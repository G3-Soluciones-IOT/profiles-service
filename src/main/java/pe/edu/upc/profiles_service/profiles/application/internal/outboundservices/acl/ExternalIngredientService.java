package pe.edu.upc.profiles_service.profiles.application.internal.outboundservices.acl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ExternalIngredientService {

    private final RestClient restClient;
    private final String internalSecret;

    public ExternalIngredientService(
            RestClient.Builder restClientBuilder,
            @Value("${profiles.integrations.recipes.base-url}") String recipesBaseUrl,
            @Value("${authorization.internal-service.secret}") String internalSecret) {
        this.restClient = restClientBuilder.baseUrl(recipesBaseUrl).build();
        this.internalSecret = internalSecret;
    }

    public boolean existsByName(String name) {
        if (name == null || name.isBlank()) return false;
        try {
            var exists = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/v1/ingredients/exists")
                            .queryParam("name", name)
                            .build())
                    .header("X-Internal-Request", internalSecret)
                    .retrieve()
                    .body(Boolean.class);
            return Boolean.TRUE.equals(exists);
        } catch (RestClientException exception) {
            return false;
        }
    }
}
