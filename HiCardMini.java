import java.util.Scanner;

public class HiCardMini extends Game {
  private Scanner sc = new Scanner(System.in);
  
  public void startGame() {

    //Making a deck and a hand for the players cards
    Deck deck1 = new Deck();
    Deck hand = new Deck();
    
    deck1.addAllCardsToDeck();
    
    System.out.println("How many cards would you like?");

    //Getting how many cards the player wants
    int desiredCards = sc.nextInt();
    while (desiredCards < 1 || desiredCards > 52) {
      System.out.println("Not a valid amount of cards.");
      desiredCards = sc.nextInt();
    }
    sc.nextLine();

    //Giving the player the cards and then getting the biggest one
    Card highestCard = new Card(1, 1);
    for (int i = 0, biggest = 0 ; i < desiredCards ; i++) {
      hand.addASingleCard(deck1.dealRandomCard());

      System.out.println(hand.getCard(i).getName());
      
      if (hand.getCard(i).getValue() > biggest){
        biggest = hand.getCard(i).getValue();
        highestCard = hand.getCard(i);
      }

      if (i == desiredCards - 1) {
        System.out.println("\nThe highest card was the " + highestCard.getName());
      }
    }
    

    sc.close();
  }
}