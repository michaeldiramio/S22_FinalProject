public class Card {
  private int value;
  private int suit;
  private String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
  private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

  public Card(int value, int suit) {
    this.value = value;
    this.suit = suit;
  }

  public int getValue() {
    return this.value;
  }

  public int getSuit() {
    return this.suit;
  }

  public String getName() {
    return values[value - 1] + " of " + suits[suit - 1];
  }
  
}