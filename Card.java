public class Card {

  private int value;
  private int suit;

  public Card (int val, int suit){
    this.value = val;
    this.suit = suit;
  }

  public int getValue(){
    return this.value;
  }

  public int getSuit(){
    return this.suit;
  }

  public String doTranslate (){
    //vals go from 1-13
    //suits go from 1-4 - hearts are 1, diamonds are 2, clubs are 3, spades are 4

    String suitName = "";
    String valName = "";
  
    if (this.suit == 1){
      suitName = "Hearts";
    } else if (this.suit == 2){
      suitName = "Diamonds";
    } else if (this.suit == 3){
      suitName = "Clubs";
    } else {
      suitName = "Spades";      
    }

    if (this.value == 1){
      valName = "Ace";
    } else if (this.value == 2){
      valName = "2";
    } else if (this.value == 3){
      valName = "3";
    } else if (this.value == 4){
      valName = "4";
    } else if (this.value == 5){
      valName = "5";
    } else if (this.value == 6){
      valName = "6";
    } else if (this.value == 7){
      valName = "7";
    } else if (this.value == 8){
      valName = "8";
    } else if (this.value == 9){
      valName = "9";
    } else if (this.value == 10){
      valName = "10";
    } else if (this.value == 11){
      valName = "Jock";
    } else if (this.value == 12){
      valName = "Queen";
    } else if (this.value == 13){
      valName = "King";
    }

    //return the card value and suit to user
    return "you got a " + valName + " of " + suitName;
  }

}