import java.util.*;

public class GuessCard extends Game{

  private Scanner sc = new Scanner(System.in);
  private ArrayList<Card> rightCard = new ArrayList<Card>();
  private ArrayList<Card> guesses = new ArrayList<Card>();

  public void startGame(){
    clear();//clear screen

    //create deck and add cards to it 
    Deck deck1 = new Deck();
    deck1.addAllCardsToDeck(); 

    rightCard.add(deck1.dealRandomCard());//get card user will try to guess

    
    System.out.println("Hello I am the Misterious Dealer. Guess the card in my hand... Here are all your options: \n");
    wait(1000);
    deck1.printDeck();

    boolean run = false;
    int counter = 0;
    int value = 0;

    int suit = 0;

      
    while (!run){
      
      boolean valid1 = false;
      boolean valid2 = false;

      System.out.println("\n" + "choose the value of the card");

      while (!valid1){ //guess validation 
        value = sc.nextInt();
        
        if (value > 0 && value < 14){
          valid1 = true;
        } else {
          System.out.println("Invalid choice");
          valid1 = false;
        }
      }
      
      System.out.println("\n hmmm... good choice. Now choose the suit \n Hearts -1 \n Diamonds - 2 \n Clubs - 3 \n Spades - 4" + "\n");
      
      while(!valid2){//guess validation 
        suit = sc.nextInt();
        
        if (suit > 0 && suit < 5){
          valid2 = true;
        } else {
          System.out.println("Invalid choice");
          valid2 = false;
        }
      }
      
      Card tempCard = new Card(value, suit);
     
      guesses.add(tempCard);
  
      System.out.println("You guessed, " + guesses.get(counter).getName());
      wait(1000);
  
      String cardSuitHint = rightCard.get(0).getName().substring(rightCard.get(0).getName().lastIndexOf(" ")); //method to get the suit of the card, to display it later as a hint 
        
      if(guesses.get(counter).getName().equals(rightCard.get(0).getName())){
        System.out.println("You guessed it right");
        run = true;
      } else {
        System.out.println("Incorrect");
        counter++;
        run = false;

        //give hints as player tries increase 
        if (counter == 3){
          System.out.println("I will give you a hint...the card suit is " + cardSuitHint);
        } else if (counter == 6){
          if(rightCard.get(0).getValue() > 7){
            wait(1000);
            System.out.println("I will give you another hint...The value of the card is big");
          } else if (rightCard.get(0).getValue() <= 7){
            wait(1000);
            System.out.println("I will give you another hint...The value of the card is small");
          } 
        } 
        
        if (counter == 10){// player tried to guess 10 times
          System.out.println("You lost");
          run = true;
        } else {
          run = false;
        }
      }
    }
  }

  static void clear(){//method to clear screen
    System.out.print("\033[H\033[2J"); 
    System.out.flush();
  }

  static void wait(int waitTime){
    try {
    Thread.sleep(waitTime);
    } catch(Exception e) {}
  }

}