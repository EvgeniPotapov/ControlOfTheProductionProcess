package addDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcConnect.DbConnect;

public class AddDetail  {

	
	public void addDetail(String partIndex, String partNumber, String name, String parsedStage) {
		DbConnect DbCon = new DbConnect();
	 
		try{
			
			String sb = "insert assembling (partindex,partnumber,name,parsedstage) values ( ? , ? , ? , ? )";
			
			PreparedStatement statment = DbCon.getConnect().prepareStatement(sb);
			statment.setString(1, partIndex);
			statment.setString(2, partNumber);
			statment.setString(3, name);
			statment.setString(4, parsedStage);
			statment.executeUpdate();
			DbCon.getConnect().close();
		
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public void addDetail(String partIndex, String partNumber, String name,String parsedStage ,String newStage) {
		DbConnect DbCon = new DbConnect();
		 
		try{
			
			String sb = "insert "+newStage+" (partindex,partnumber,name,parsedstage) values ( ? , ? , ? , ? )";
			
			PreparedStatement statment = DbCon.getConnect().prepareStatement(sb);
			statment.setString(1, partIndex);
			statment.setString(2, partNumber);
			statment.setString(3, name);
			statment.setString(4, parsedStage);
			statment.executeUpdate();
			
			DbCon.getConnect().close();
		
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		
	}




}
