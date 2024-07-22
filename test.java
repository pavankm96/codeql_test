import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferServlet extends HttpServlet {
    private CSRFTokenManager tokenManager = new CSRFTokenManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String token = tokenManager.generateToken();
        session.setAttribute(CSRFTokenManager.CSRF_TOKEN_NAME, token);
        req.getRequestDispatcher("/transferForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String token = (String) session.getAttribute(CSRFTokenManager.CSRF_TOKEN_NAME);
        if (tokenManager.validateToken(req.getParameter(CSRFTokenManager.CSRF_TOKEN_NAME))) {
            // Process the request
            String amountStr = req.getParameter("amount");
            String toAccountStr = req.getParameter("toAccount");

            // Convert parameters to integers, validate them, etc.
            // In a real application, you would also check if the user has enough money, etc.

            // Transfer the money
            // ...
        } else {
            // Reject the request
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
