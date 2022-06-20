import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Roulette extends Game {
  ArrayList<Integer> nums = new ArrayList<Integer>();
  ArrayList<String> colours = new ArrayList<String>();

  public void startGame() {
    this.assignColoursNumbers();
    // this.bet();
    // this.spin();
    // result = this.getResult();

    for (int i = 0; i < nums.size(); i++) {
      System.out.println(nums.get(i) + " " + colours.get(i));

    }

  }

  public void assignColoursNumbers() {
    for (int i = 0; i < 35; i++) {
      nums.add(i);
    }
    colours.add("Green");
    for (int i = 1; i < nums.size(); i = i + 2) {
      colours.add("Red");
    }
    for (int i = 2; i < nums.size(); i = i + 2) {
      colours.add("Black");
    }
  }

  public String gameName() {
    return "Roulette";
  }

}