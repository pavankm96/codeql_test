import java.util.UUID;

public class CSRFTokenManager {
    public static final String CSRF_TOKEN_NAME = "csrfToken";

    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public boolean validateToken(String token) {
        // In a real application, you would store tokens in the user's session
        // and check if the provided token matches the stored one.
        // For simplicity, we'll just check if the token is not null or empty.
        return token != null && !token.isEmpty();
    }
}
