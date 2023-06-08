package searchDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnect.DbConnect;

public class SearchDetail {
	
	public String searchIndex (String partindex) {

		DbConnect DbCon = new DbConnect();
		String[] dataBase = {"assembling","cleansing","delivery","drobestruy","packing","painting"};
		boolean tr = false;
		String n;
		String Stagob="null";
		String res= "null";
		
		
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
					 res=tabl;
					 Stagob=resultSet.getString("parsedstage");
					 break;	 
			  }
			}
			
			stat.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
		
		String position;
		
		switch(res) {
		
		case "assembling":
			position ="Сборка";
			break;
			
	    case "cleansing":
				position ="Зачистка";
				break;
				
	    case "delivery":
				position ="Доставка";
				break;
				
	    case "drobestruy":
				position ="Дробеструй";
				break;
				
	    case "packing":
				position ="Упаковка";
				break;
				
	    case "painting":
				position ="Покраска";
				break;
				
		default : position = "Данной детали нет в базе данных";
		break;
		}
		return position+". Стадии прошедшие деталью: "+ Stagob;
	}
	public boolean searchIndexChecking (String partindex,String stage) {

		DbConnect DbCon = new DbConnect();
		boolean tr = true;
		String n;
		
		try{
			
			String inquiry = "SELECT * FROM "+stage;
			
			Statement stat = DbCon.getConnect().createStatement();
			
			ResultSet resultSet = stat.executeQuery(inquiry);
			
			while(resultSet.next()) {
				
			n = resultSet.getString("partindex");
			
			  if(n.equals(partindex)) {
		        	
					 tr = false;
					 break;	 
			  }
			}
			
			stat.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
		
		return tr;
	}

}
