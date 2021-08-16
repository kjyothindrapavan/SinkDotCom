import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("G02.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, G02.com");
		System.out.println("try to sink them all in the fewest number of guesses");
		
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		for(DotCom dotComToSet : dotComsList) {
			result = dotComToSet.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")){
				dotComsList.remove(dotComToSet);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worth less.");
		if(numOfGuesses <= 18) {
			System.out.println("It only took  "+numOfGuesses+" guesses.");
			System.out.println("You got before your options sank.");
		} else {
			System.out.println("You took too long enough. "+numOfGuesses+" guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
	
	public static void main(String args[]) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}