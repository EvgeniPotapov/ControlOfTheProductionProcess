package changeOfStage;

public class InitializationStage {
	
	public String initStage (String parsedStage, String newStage) {
		
		String position;
		switch(newStage) {
		
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
				
		default : position = "null";
		break;
		}
		return parsedStage+", "+position;
	}

}
