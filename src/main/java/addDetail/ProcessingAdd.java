package addDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/ProcessingAdd")
public class ProcessingAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");	
		String partIndex = request.getParameter("partIndex");
		String partNumber = request.getParameter("partNumber");
		String name = request.getParameter("name");
		String parsedStage = "Сборка";
		AddDetail addDet = new AddDetail();
		ReplayPartIndex replay = new ReplayPartIndex();
		
		if(StringUtils.isNotBlank(partIndex)&&StringUtils.isNotBlank(partNumber)&& StringUtils.isNotBlank(name)) {
		
		  if(replay.checking(partIndex)) {
			 request.getRequestDispatcher("/WEB-INF/repitName.jsp").forward(request, response);
			 }else {
			addDet.addDetail(partIndex, partNumber, name, parsedStage);
			request.getRequestDispatcher("/WEB-INF/greatRegistration.jsp").forward(request, response);
		}
			
	}else {request.getRequestDispatcher("/WEB-INF/isNotAdd.jsp").forward(request, response);}

  }
}
