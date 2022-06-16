import java.util.*;

public class Guts extends Game {
  private Deck d = new Deck();
  private ArrayList<Card> playerHand = new ArrayList<Card>();
  private ArrayList<Card> dealerHand = new ArrayList<Card>();
  private int dealerVal = 0;
  private int playerVal = 0;
  private boolean playerWin = false;

  public void startGame(Player player){

    // everyone gets two cards
    playerHand.add(d.dealRandomCard());
    dealerHand.add(d.dealRandomCard());
    playerHand.add(d.dealRandomCard());
    dealerHand.add(d.dealRandomCard());

    // print the hands
    System.out.println("Player hand:");
    System.out.println(playerHand.get(0).getName() + " and " + playerHand.get(1).getName());

    System.out.println("Dealer hand:");
    System.out.println(dealerHand.get(0).getName() + " and " + dealerHand.get(1).getName());

    // get value of the high card

    playerVal = playerHand.get(0).getValue();
    dealerVal = dealerHand.get(0).getValue();

    if(playerHand.get(0).getValue() < playerHand.get(1).getValue()){
      playerVal = playerHand.get(1).getValue();
    }
    if(dealerHand.get(0).getValue() < dealerHand.get(1).getValue()){
      dealerVal = dealerHand.get(1).getValue();
    }

    // check for pairs
    if(dealerHand.get(0).getValue() == dealerHand.get(1).getValue()){
      dealerVal = 100 + dealerHand.get(0).getValue();
    }
    if(playerHand.get(0).getValue() == playerHand.get(1).getValue()){
      playerVal = 100 + playerHand.get(0).getValue();
    }

    // if the player hand value is higher than the dealers player wins if not dealer wins, if tied then checks who has the higher low card and makes them the winner
    if(playerVal > dealerVal){
      playerWin = true;
      System.out.println("win");
    }else if(playerVal < dealerVal){
      playerWin = false;
      System.out.println("lose");
    }else{
      // low card check
      playerVal = playerHand.get(0).getValue();
      dealerVal = dealerHand.get(0).getValue();

      if(playerHand.get(0).getValue() < playerHand.get(1).getValue()){
        playerVal = playerHand.get(1).getValue();
      }
      if(dealerHand.get(0).getValue() < dealerHand.get(1).getValue()){
        dealerVal = dealerHand.get(1).getValue();
      }
      if(playerVal > dealerVal){
        playerWin = true;
        System.out.println("win");
      }else if(playerVal < dealerVal){
        playerWin = false;
        System.out.println("lose");
      }
    }
  }
}