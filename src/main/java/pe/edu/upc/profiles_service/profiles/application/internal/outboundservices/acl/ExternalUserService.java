package pe.edu.upc.profiles_service.profiles.application.internal.outboundservices.acl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ExternalUserService {

    private final RestClient restClient;
    private final String internalSecret;

    public ExternalUserService(
            RestClient.Builder restClientBuilder,
            @Value("${profiles.integrations.iam.base-url}") String iamBaseUrl,
            @Value("${authorization.internal-service.secret}") String internalSecret) {
        this.restClient = restClientBuilder.baseUrl(iamBaseUrl).build();
        this.internalSecret = internalSecret;
    }

    public boolean userExists(Long userId) {
        if (userId == null || userId <= 0) return false;
        try {
            var username = restClient.get()
                    .uri("/api/v1/users/{userId}/username", userId)
                    .header("X-Internal-Request", internalSecret)
                    .retrieve()
                    .body(String.class);
            return username != null && !username.isBlank();
        } catch (RestClientException exception) {
            return false;
        }
    }
}
