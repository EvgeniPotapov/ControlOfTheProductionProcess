package changeOfStage;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import searchDetail.SearchDetail;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import addDetail.AddDetail;




@WebServlet("/ProcessingChangeStage")
public class ProcessingChangeStage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 
			String partIndex = request.getParameter("partIndex");
			String stage = request.getParameter("stage");
			String NewStage = request.getParameter("newstage");
			
			DelitDetail delit = new DelitDetail();
			AddDetail add = new AddDetail();
			SearchDetail searc = new SearchDetail();
			InitializationStage initStage = new InitializationStage();
			 
			
			  if(StringUtils.isNotBlank(stage)&&StringUtils.isNotBlank(NewStage)&&StringUtils.isNotBlank(partIndex)) {
		
			      	 if(!searc.searchIndexChecking(partIndex,stage)) {
			      		 
			      		if(!stage.equals(NewStage)) {
			      			 delit.deliteDetail(partIndex, stage);
			      		     String pars =initStage.initStage(delit.parsedStage, NewStage);
			      		     add.addDetail(partIndex, delit.partNumber,delit.detailName,pars,NewStage);
			      		     request.getRequestDispatcher("/WEB-INF/changeposition.jsp").forward(request, response);
			      		     
			      		     }else {request.getRequestDispatcher("/WEB-INF/repitStage.jsp").forward(request, response);}
			      		 
			      	 }else {request.getRequestDispatcher("/WEB-INF/SearchNon.jsp").forward(request, response);}
			         
			  }else {request.getRequestDispatcher("/WEB-INF/nonStage.jsp").forward(request, response);}
			  

	}

}



