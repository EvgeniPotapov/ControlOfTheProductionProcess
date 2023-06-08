package searchDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ProcessingSerch")
public class ProcessingSerch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 
		String partIndex = request.getParameter("partIndex");
		SearchDetail search = new SearchDetail();
		
		request.setAttribute("Position", search.searchIndex(partIndex));
		
		request.getRequestDispatcher("/WEB-INF/PositionDetail.jsp").forward(request, response);
	}

}
