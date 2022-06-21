import java.util.*;

public class CoinFlip extends Game {

  public void startGame(Player player) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int guess = 7;

    System.out.println("Guess heads or tails?");

    boolean validAnswer = false;
    // gets user input until they input heads or tails
    while (!validAnswer) {
      String response = sc.nextLine();
      // set guess to 0 or 1 respectively
      if (response.equalsIgnoreCase("heads")) {
        guess = 0;
        validAnswer = true;
      } else if (response.equalsIgnoreCase("tails")) {
        guess = 1;
        validAnswer = true;
      } else {
        System.out.println("invalid reponse");
      }
    }
    // gets random number 0 or 1 and compares to guess
    if (guess == rand.nextInt(100) % 2) {
      System.out.println("you guessed right");
    } else {
      System.out.println("you were wrong");
    }
    
    System.out.println("press any key to continue");
    String cont = "";
    while (cont.equals("")) {
      cont = s.next();
    }
  }

  public String gameName() {
    return "Coin Flip";
  }
}