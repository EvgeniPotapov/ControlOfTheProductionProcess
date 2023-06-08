package addDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnect.DbConnect;

public class ReplayPartIndex {
	
	public boolean checking (String partindex) {

		DbConnect DbCon = new DbConnect();
		String[] dataBase = {"assembling","cleansing","delivery","drobestruy","packing","painting"};
		boolean tr = false;
		String n;
		
		
		for(String tabl: dataBase) {
			
			if(tr) {
				break;
			}
			
		try{
			
			String inquiry = "SELECT * FROM "+tabl;
			
			Statement stat = DbCon.getConnect().createStatement();
			
			ResultSet resultSet = stat.executeQuery(inquiry);
			
			while(resultSet.next()) {
				
			n = resultSet.getString("partindex");
			
			  if(n.equals(partindex)) {
		        	
					 tr = true;
					 
					 break;
				}
			}
			stat.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	
      return tr;
	}

}
