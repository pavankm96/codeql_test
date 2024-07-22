import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CSRFTokenManager {
    public static final String CSRF_TOKEN_NAME = "csrfToken";

    public static String generateToken(HttpSession session) {
        String token = UUID.randomUUID().toString();
        session.setAttribute(CSRF_TOKEN_NAME, token);
        return token;
    }

    public static boolean validateToken(HttpServletRequest request) {
        String token = request.getParameter(CSRF_TOKEN_NAME);
        String sessionToken = (String) request.getSession().getAttribute(CSRF_TOKEN_NAME);
        return token != null && token.equals(sessionToken);
    }
}
