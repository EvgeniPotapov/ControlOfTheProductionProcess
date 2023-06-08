package changeOfStage;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnect.DbConnect;

public class DelitDetail {
	String partNumber;
	 String detailName;
	 String parsedStage;
	public void deliteDetail(String partIndex,String stage) {
		
		DbConnect DbCon = new DbConnect();
		
		
		try{
			
			String inquiry = "SELECT * FROM "+stage;
			
			Statement stat = DbCon.getConnect().createStatement();
			
			ResultSet resultSet = stat.executeQuery(inquiry);
			
			while(resultSet.next()) {
				
			String n = resultSet.getString("partindex");
			
			  if(n.equals(partIndex)) {
				  
				partNumber=resultSet.getString("partnumber");
				detailName=resultSet.getString("name");
				parsedStage=resultSet.getString("parsedstage");
				  
				  
				String queri = "delete from dotheway."+stage+" where partindex = "+partIndex;
		        	
					int st =stat.executeUpdate(queri);
					 
					 break;
				}
			}
			stat.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	
	}


