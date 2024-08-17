import java.util.*;

public class DotComBust{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame(){
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		System.out.println("You'r goal is to hit 3 sites");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("You should have a as little tries as posible");

		for (DotCom dotComToSet : dotComsList){
			ArrayList<String> newLocation = helper.placeDotCom(3);

			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying(){
		while (!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Try to hit the sites: ");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result = "Missed";
		for (DotCom dotComToTest : dotComsList){
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("Damaged")){
				break;
			}
			if (result.equals("Hit")){
				dotComsList.remove(dotComToTest);
				break;
			}
		}	
		System.out.println(result);
	}
	
	private void finishGame(){
		System.out.println("All sites were hit! Your stonks are useless now.");
		if (numOfGuesses <= 18){
			System.out.println("It took you " + numOfGuesses + " tries.");
			System.out.println("You're good and have profit.");
		} else {
			System.out.println("It took you a lot of time. " + numOfGuesses + " tries.");
			System.out.println("Now you hase so many bills to pay...");
		}
	}	

	public static void main (String[] args){
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}