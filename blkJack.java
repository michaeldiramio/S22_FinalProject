import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class blkJack extends Game {
  private Player p;
	private ArrayList<Card> pCards = new ArrayList<Card>(); //holds the players cards
	private ArrayList<Card> dCards = new ArrayList<Card>(); //holds dealers cards
	Deck deck = new Deck();

	
	public void startGame(Player p) { //the main game method. 
    this.p = p;
    
		Scanner input = new Scanner(System.in);
		int play = 1; //keeps the loop playing before ending game
		int bet = this.initializeMenu(); //keeps bets
		this.dealCards(); //deals the original cards
		this.printStatus(); //prints original cards plus hides dealer second card
		play = this.checkBlackjack(); //checks if either have 21 valued deck.

		while(play > 0) { //this loop goes until someone stands or bust. Hit or Stand, if the player stands the dealer will add until they get to above 17. 
			play = this.hitOrStand(); //they will return a postive meaning that the loop will continue, the negative will signal that the game is done: -1 equals the player won, -2 - The Dealer Won, -3 It was a push, -4 Blackjack for the Player, the different numbers dont matter except for to make sure the right payout is given
		}

		this.getRewards(play, bet); //gives out rewards based on the play value.
		System.out.println("Press any key to continue"); 
		String i ="";
		while(i.equalsIgnoreCase("")) {
			i = input.nextLine();
		}
	}

	//BlackJack Methods

	public int initializeMenu() { //Prints the Main Menu and Gets Bets
		Scanner input = new Scanner(System.in);
		clear();
    System.out.println("Hello " + this.p.getName());
		System.out.println("Welcome to the Blackjack Table");
		System.out.print("What is your bet?: ");
		int bet = input.nextInt();
		this.p.addSubMoney(-bet);
		System.out.println(bet + " has been taken out of your account.");
		System.out.println("------------------------------------");
		return bet;
	}

	public void dealCards() { //Deals Original Cards
		deck.addAllCardsToDeck();
		for(int i = 0; i <= 1; i++) {
			dCards.add(deck.dealRandomCard());
			pCards.add(deck.dealRandomCard());
		}
	}

	public void printCards() { //Prints Only Players Cards
		System.out.print("Your cards are: ");
		for(int i = 0; i < pCards.size(); i++) {
			System.out.print("[" + pCards.get(i).getName() + "]");
		}
		System.out.println(" - Total Value of " + getPTotal());
	}

	public int hitOrStand() { //This is where the player can add on cards until they bust or want to stand. If the player stands the dealerStarts method will be played.
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like to Hit(H) or Stand(S): ");
		String hs = input.nextLine();

		if(hs.equalsIgnoreCase("H")) {
			System.out.println("The dealer gave you a card from the deck");
			pCards.add(deck.dealRandomCard());
			this.printCards();

			if(getPTotal() > 21) {
				System.out.println("Bust");
				return -2;
			}
			
		} else if(hs.equalsIgnoreCase("S")) {
			return this.dealerStarts();

			
		} else {
			System.out.println("Incorrect Input.");
			return 1;
		}
		return 1;
	}

	public int dealerStarts() { //this will get the dealer to keep adding cards to their deck until they are above 17, thats when they will compare values with the player to see who won.
		while(getDTotal() < 17) {
			dCards.add(deck.dealRandomCard());
		}
		
		System.out.print("Dealer's Card: ");
		for(int i = 0; i < dCards.size(); i++) {
			System.out.print("[" + dCards.get(i).getName() + "]");
		}
		System.out.println(" - Total Value of " + getDTotal());
		
		if(getDTotal() > 21) {
			System.out.println("The Dealer Busted");
			return -1;
		} else if(getDTotal() > getPTotal()) {
			System.out.println("The Dealer Won");
			return -2;
			
		} else if(getDTotal() < getPTotal()) {
			System.out.println("You won!!!");
			return -1;
			
		} else if(getDTotal() == getPTotal()) {
			System.out.println("Push");
			return -3;
		}

		return 0;

		
	}

	public int checkBlackjack() { //checks if either player or dealer have blackjack at the start of the game.
	  if(getPTotal() == 21 && getDTotal() != 21) {
			System.out.println("Blackjack!");
			return -4;
		} else {
			return 1;
		}
	}

	public void getRewards(int result, int bet) { //payout awards based on push, win, lose, etc.
		if(result == -1) {
			System.out.println("Here is your reward of $" + (bet*2));
			this.p.addSubMoney(bet * 2);
		} else if(result == -2) {
			System.out.println("You lost $" + bet);
		} else if(result == -3) {
			System.out.println("You got your money back");
			this.p.addSubMoney(bet);
		} else if(result == -4) {
			System.out.println("Here is your reward of $" + (bet*3));
			this.p.addSubMoney(bet*3);
		}
	}

	public void printStatus() { //prints the dealer and player cards at the start of the game.
		System.out.println();
		System.out.println("Dealer has [" + dCards.get(0).getName() + "] and the second card is secreted");
		System.out.println();
		System.out.print("Your cards are: ");
		for(int i = 0; i < pCards.size(); i++) {
			System.out.print("[" + pCards.get(i).getName() + "]");
		}
		System.out.println(" - Total Value of " + getPTotal());

	}

	public void clearHands() { //clears the hand of both dealer and player.
		dCards.clear();
		pCards.clear();
	}

	//Helpful Methods but are not Blackjack Specific

	public int getPTotal() { //adds up the totals of the deck for the player.
		int sum = 0, value = 0;
		for(int i = 0; i < pCards.size(); i++) {
			value = pCards.get(i).getValue();
			if(value > 10) {
				value = 10;
			}
			sum = value + sum;
		}		
		return sum;
	}

	public int getDTotal() { //adds the dealers deck value.
		int sum = 0, value = 0;
		for(int i = 0; i < dCards.size(); i++) {
			value = dCards.get(i).getValue();
			if(value > 10) {
				value = 10;
			}
			sum = value + sum;
		}		
		return sum;
		
	}

	static void clear() { //method to clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  //This method returns the changed player
  public Player returnPlayer () {
    return this.p;
  }

	  public String gameName() {
    return "Blackjack";
  }

	
}