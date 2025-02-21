import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.JSONObject;

public class VotingSystemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        JSONObject json = new JSONObject(sb.toString());
        String candidate = json.getString("candidate");

        // Simulate blockchain logic (For now, just print the vote)
        System.out.println("Vote received for: " + candidate);

        // Send response
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"Vote successfully recorded!\"}");
    }
}
