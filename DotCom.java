import java.util.*;

public class DotCom{
	private ArrayList<String> locationCells;
	private String name;

	public void setLocationCells (ArrayList<String> loc){
		locationCells = loc;
	}

	public void setName (String n){
		name = n;
	}	

	public String checkYourself (String userInput){
		String result = "Missed";
		int index = locationCells.indexOf(userInput);

		if (index >= 0) {
			locationCells.remove(index);

			if (locationCells.isEmpty()){
				result = "Hit";
				System.out.println("You sunk " + name);
			} else {
				result = "Demaged";
			}
		}
		
		return result;
	}
}