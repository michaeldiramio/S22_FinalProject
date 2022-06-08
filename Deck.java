import java.util.ArrayList;
import java.util.Random;

public class Deck {
  //Card arraylist / deck
  private ArrayList<Card> cards = new ArrayList<Card>();
  
  public Deck() {
    addAllCardsToDeck();
  }

  //A method that deals a random card and removes that card from the deck
  public Card dealRandomCard() {
    Random rd = new Random();
    Card randomCard = cards.remove(rd.nextInt(cards.size()));
    return randomCard;
  }

  //A method to clear the deck and add all cards back to it
  public void resetDeck() {
    cards.clear();
    addAllCardsToDeck();
    System.out.println("[DECK RESET]\n");
  }

  //A method that adds all cards to an empty deck
  public void addAllCardsToDeck() {
    for (int i = 1 ; i <= 4 ; i++) {
      for (int j = 1 ; j <= 13 ; j++) {
        Card tempCard = new Card(j, i);
        this.cards.add(tempCard);
      }
    }
  }

  //A method that prints the deck
  public void printDeck() {
    for (int i = 0 ; i < cards.size() ; i++) {
      System.out.println(cards.get(i).getName());
    }
  }
  
}