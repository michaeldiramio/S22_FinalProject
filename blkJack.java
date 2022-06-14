import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class blkJack extends Game {
	private ArrayList<Card> pCards = new ArrayList<Card>();
	private ArrayList<Card> dCards = new ArrayList<Card>();
	Deck deck = new Deck();

	
	public void startGame() {
		Scanner input = new Scanner(System.in);
		
		this.initializeMenu();
		this.dealCards();
		this.printStatus();
		this.checkBlackjack();
		this.hitOrStand();
		
		

		
			
	}

	//BlackJack Methods

	public void initializeMenu() {
		
		clear();
		System.out.println("Welcome to the Blackjack Table");
		
	}

	public void dealCards() {
		
		for(int i = 0; i <= 1; i++) {
			dCards.add(deck.dealRandomCard());
			pCards.add(deck.dealRandomCard());
		}
		
	}

	public void printCards() {
		System.out.print("Your cards are: ");
		for(int i = 0; i < pCards.size(); i++) {
			System.out.print("[" + pCards.get(i).getName() + "]");
		}
		System.out.println(" - Total Value of " + getPTotal());
	}

	public void hitOrStand() {
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like to Hit(H) or Stand(S): ");
		String hs = input.nextLine();

		if(hs.equalsIgnoreCase("H")) {
			System.out.println("The dealer gave you a card from the deck");
			pCards.add(deck.dealRandomCard());
			this.printCards();
			
		} else if(hs.equalsIgnoreCase("S")) {

			
		} else {System.out.println("Incorrect Input");}
	}

	public void checkBlackjack() {
		
		if(getDTotal() == 21) {
			if(getPTotal() == 21) {
				System.out.println("Push");
			}
		}

		
	}

	public void printStatus() {
		System.out.println("Dealer has [" + dCards.get(0).getName() + "] and the second card is secreted");
		System.out.print("Your cards are: ");
		for(int i = 0; i < pCards.size(); i++) {
			System.out.print("[" + pCards.get(i).getName() + "]");
		}
		System.out.println(" - Total Value of " + getPTotal());

	}

	public void clearHands() {
		dCards.clear();
		pCards.clear();
	}

	

	//Helpful Methods but are not Blackjack Specific

	public int getPTotal() {
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

	public int getDTotal() {
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


	//Methods that need to Change

	public void printCards(char p) {
		if(p == 'd') {
			System.out.println("Dealers Hand: ");
			System.out.print("[" + dCards.get(0).getName() + "]");
			System.out.println("[?]");
			

			
		} else if(p == 'p') {
			System.out.println("Players Hand: ");
			int sum = 0, value = 0;
			for(int i = 0; i < pCards.size(); i++) {
				System.out.print("[" + pCards.get(i).getName() + "]");
				value = dCards.get(i).getValue();
				if(value > 10) {
					value = 10;
				}
				sum = sum + value;
			}
			System.out.println(" Total: " + sum);
			
			
		}
	}



	
}