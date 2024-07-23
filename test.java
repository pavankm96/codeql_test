import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CSRFProtection {
    public static String generateCSRFToken(HttpSession session) {
        String token = UUID.randomUUID().toString();
        session.setAttribute("csrf_token", token);
        return token;
    }

    public static boolean validateCSRFToken(HttpServletRequest request) {
        String token = request.getParameter("csrf_token");
        String sessionToken = (String) request.getSession().getAttribute("csrf_token");
        return token != null && token.equals(sessionToken);
    }

    public void doPost(HttpServletRequest request) {
        if (!validateCSRFToken(request)) {
            throw new SecurityException("Invalid CSRF token");
        }
        String userAction = request.getParameter("action");
        // Perform action
    }
}
