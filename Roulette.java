import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Roulette extends Game {
	private Player p;
  ArrayList<Integer> nums = new ArrayList<Integer>();
  ArrayList<String> colours = new ArrayList<String>();

  public void startGame(Player p) {
		boolean keepPlay = true;
		while(keepPlay) {
			this.clear();
			this.p = p;
    	this.assignColoursNumbers(); //assigns numbers to 36 in an array and assign those numbers colours using an identical string array.

			Scanner input = new Scanner(System.in); 
			System.out.println("Please Enter your Guess | [B]lack [R]ed or Enter a Number up to 36"); //13-29 takes in your guess and bet
			String guess = input.nextLine();
			int numGuess = -1;
			int bet = 0;

			try { //differentiates if it was a guess for the colour or number
				numGuess = Integer.parseInt(guess);
				System.out.println("How Much would you like to bet on " + numGuess);

			} catch (NumberFormatException e) {
			
				guess = guess.toUpperCase();
				System.out.println("How Much would you like to bet on " + guess);
				
			}

			bet = input.nextInt(); //gets bet and takes away from person.
			this.p.addSubMoney(-bet);

    	int result = this.spin(numGuess,guess); //calls the method spin

			if(result == -1) { //gives money to player if they won. X2 If they guessed the colour, X3 if they guessed the number
				this.p.addSubMoney(bet * 2);
				System.out.println("You have been given " + (bet*2));
			} else if(result == -2) {
				this.p.addSubMoney(bet * 3);
				System.out.println("You have been given " + (bet*3));
			}

			String Input = "";
			System.out.println("Would you like to exit? Y/N");
			while(!Input.equalsIgnoreCase("N") && keepPlay == true) { //play again loop to exit or keep playing.
				Input = input.nextLine();
				if(Input.equalsIgnoreCase("Y"))  {
				keepPlay = false;
				}
			}
			

		}
  }

	public int spin(int numGuess, String guess) { //takes a random number, sees if your colour bet or number bet was successfull
		Random rand = new Random();
		System.out.println("Spinning.");
		System.out.println("Spinning..");
		System.out.println("Spinning...");
		int landed = rand.nextInt(nums.size());

		if(numGuess != -1 && numGuess == landed) {
			System.out.println("You WON");
			return -2;
			
			
		} else if(numGuess == -1 && guess.equalsIgnoreCase(colours.get(landed))) {
			System.out.println("You WON");
			return -1;

			
		} else {
			System.out.println("You Lost");
			return -3;
		}

	}



	




  public void assignColoursNumbers() { //assigns colours and numbers to arrays to compare later and to select where it will land when it spins
    for (int i = 0; i < 35; i++) {
      nums.add(i);
    }
    colours.add("GREEN");
    for (int i = 1; i < nums.size(); i = i + 2) {
      colours.add("RED");
    }
    for (int i = 2; i < nums.size(); i = i + 2) {
      colours.add("BLACK");
    }
  }

	static void clear() { //method to clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

	public Player returnPlayer() {
    return this.p;
  }


  public String gameName() {
    return "Roulette";
  }

}