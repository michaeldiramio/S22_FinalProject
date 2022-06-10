import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
	  System.out.println("---------WELCOME---------" + "\n" + "this is the Ultimate Card Game Center, in here you will find amazing card games and even games that you can use your money!" + "\n\n" + "Press Enter key to join the Ultimate Card Game Center");

    String pressEnter = sc.nextLine();

    if (pressEnter.equals("")){
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
    }
    
    //get name
    System.out.println("Please enter your name: " ); 
    String playerName = sc.nextLine();

    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    //creating player 
    Player player1 = new Player(playerName, 1000, 01);

    //array of games
    String [] games = {"Blackjacks", "Crazy 8s", "99", "Baccarat", "3 card poker", "Guess the card", "Higher or Lower"};

    System.out.println(player1.getName() + ", your current balance is: " + player1.getMoney() + "\n\n" + "Choose the game you want to play? " + "\n");

    for (int i = 0; i < games.length; i++){
      System.out.println(games[i] + " - " + i);
    }
    
    int gameChoice = sc.nextInt();
    System.out.println();

    if (gameChoice == 1){
      System.out.println("You chose, " + games[0]);
    } else if (gameChoice == 2){
      System.out.println("You chose, " + games[1]);
    } else if (gameChoice == 3){
      System.out.println("You chose, " + games[2]);
    } else if (gameChoice == 4){
      System.out.println("You chose, " + games[3]);
    } else if (gameChoice == 5){
      System.out.println("You chose, " + games[4]);
    } else if (gameChoice == 6){
      System.out.println("You chose, " + games[5]);
    }

    //Start game code goes here

    
    
    //Card tests
    System.out.println("\n" + "-----Card Tests-----");
    
    Card card1 = new Card(1, 4);
    System.out.println(card1.getName());

    Card card2 = new Card(13, 3);
    System.out.println(card2.getName());

    Card card3 = new Card(12, 2);
    System.out.println(card3.getName());

    Card card4 = new Card(6, 1);
    System.out.println(card4.getName());

    System.out.println();

    //Deck Tests
    System.out.println("\n" + "-----Deck Tests-----");
    Deck deck1 = new Deck();

    //Getting 5 random cards
    for (int i = 0 ; i < 5 ; i++) {
      System.out.println(deck1.dealRandomCard().getName());
    }
    System.out.println("\n");

    
    


	}
}