import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CSRFVulnerability {
    public void doPost(HttpServletRequest request) {
        String userAction = request.getParameter("action");
        // Perform action without verifying CSRF token
    }
}
