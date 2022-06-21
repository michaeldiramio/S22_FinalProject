import java.util.Random;
import java.util.Scanner;

public class SlotMachine extends Game {
  
  private Player p;
  private String[] types = {"🍋", "🍇", "🍒", "🔔", "⓻"};

  private String[] slots = new String[3];

  Random rd = new Random();

  Scanner sc = new Scanner(System.in);
  
  public void startGame(Player p) {
    this.p = p;

    //While the player does not want to exit game
    String selection = new String("");
    while (!selection.equalsIgnoreCase("x")) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println(this.p.getName() + "\t\t\tBalance: $" + this.p.getBalance() + "\n");
      System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|   _\n\t|\t\t\t\t\t  | /   \\\n\t|\t\t\t\t\t  | \\ _ /\n\t|\t\t\t\t\t  |  | |\n\t|\t\t\t\t\t  |  | |\n\t|\t\t\t\t\t  |_ | |\n\t|\t\t\t\t\t  | \\| |\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 
      //If there is something in the slots say what needs to be said
      if (slots[0] != null) {
        System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[2] + "]");
        if (slots[0].equals("🍋") && slots[1].equals("🍋") && slots[2].equals("🍋")) {
          System.out.println("Triple Lemon! You earned 1 times your bet amount!");
        }
        if (slots[0].equals("🍇") && slots[1].equals("🍇") && slots[2].equals("🍇")) {
          System.out.println("Triple Grape! You earned 10 times your bet amount!");
        }
        if (slots[0].equals("🍒") && slots[1].equals("🍒") && slots[2].equals("🍒")) {
          System.out.println("Triple Cherry! You earned 25 times your bet amount!");
        }
        if (slots[0].equals("🔔") && slots[1].equals("🔔") && slots[2].equals("🔔")) {
          System.out.println("Triple Bell! You earned 50 times your bet amount!");
        }
        if (slots[0].equals("⓻") && slots[1].equals("⓻") && slots[2].equals("⓻")) {
          System.out.println("Triple 7! You earned 100 times your bet amount!");
        }
      } else { //else just print slots
        System.out.println("\n[][][]");
      }

      
      System.out.println("Would you like to take a ('s')pin  or  e('x')it? (100 dollars per spin)");

      //While selection does not equal s or x
      selection = sc.nextLine();
      while (!selection.equalsIgnoreCase("s") && !selection.equalsIgnoreCase("x")) {
        System.out.println("Not a valid choice");

        selection = sc.nextLine();
      }

      //If selection equals s
      if (selection.equalsIgnoreCase("s")) {
        if (this.p.getBalance() >= 100) {
          //Minus 100 dollars
          this.p.addSubMoney(-100);
          //Pull lever
          pullLever();

          //If then add stuff based on what get
          if (slots[0].equals("🍋") && slots[1].equals("🍋") && slots[2].equals("🍋")) {
            this.p.addSubMoney(100 * 1);
          }
          if (slots[0].equals("🍇") && slots[1].equals("🍇") && slots[2].equals("🍇")) {
            this.p.addSubMoney(100 * 10);
          }
          if (slots[0].equals("🍒") && slots[1].equals("🍒") && slots[2].equals("🍒")) {
            this.p.addSubMoney(100 * 25);
          }
          if (slots[0].equals("🔔") && slots[1].equals("🔔") && slots[2].equals("🔔")) {
            this.p.addSubMoney(100 * 50);
          }
          if (slots[0].equals("⓻") && slots[1].equals("⓻") && slots[2].equals("⓻")) {
            this.p.addSubMoney(100 * 100);
          }
        } else {
          System.out.println("Not enough money :(");
        }
      }


      
    }
    
  }

  //Lever animation
  public void pullLever() {
    lever2();

    lever3();

    lever4();

    lever5();

    lever4();

    lever3();

    lever2();

    lever1();
  }

  //Lever animations
  public void lever1() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    randomize();
    
    System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|   _\n\t|\t\t\t\t\t  | /   \\\n\t|\t\t\t\t\t  | \\ _ /\n\t|\t\t\t\t\t  |  | |\n\t|\t\t\t\t\t  |  | |\n\t|\t\t\t\t\t  |_ | |\n\t|\t\t\t\t\t  | \\| |\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 


    System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[1] + "]");

    try {
      Thread.sleep(80);
    } catch (Exception e) {
    }
  }

  public void lever2() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    randomize();
    
    System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|\n\t|\t\t\t\t\t  |   _\n\t|\t\t\t\t\t  | /   \\\n\t|\t\t\t\t\t  | \\ _ /\n\t|\t\t\t\t\t  |  | |\n\t|\t\t\t\t\t  |_ | |\n\t|\t\t\t\t\t  | \\| |\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 

   
    System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[1] + "]");

    try {
      Thread.sleep(80);
    } catch (Exception e) {
    }
  }

  public void lever3() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    randomize();
    
    System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |   _\n\t|\t\t\t\t\t  | /   \\\n\t|\t\t\t\t\t  | \\ _ /\n\t|\t\t\t\t\t  |_ | |\n\t|\t\t\t\t\t  | \\| |\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 

    
    System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[1] + "]");

    try {
      Thread.sleep(80);
    } catch (Exception e) {
    }
  }

  public void lever4() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    randomize();
    
    System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |   _\n\t|\t\t\t\t\t  | /   \\\n\t|\t\t\t\t\t  |_\\ _ /\n\t|\t\t\t\t\t  | \\| |\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 


    System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[1] + "]");

    try {
      Thread.sleep(80);
    } catch (Exception e) {
    }
  }

  public void lever5() {
    System.out.print("\033[H\033[2J");
    System.out.flush();

    randomize();
    
    System.out.println("\t  ___-------------___ \n\t/    [S][L] [O][T]    \\\n\t|_____________________|\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |\n\t|\t\t\t\t\t  |   _\n\t|\t\t\t\t\t  |_/   \\\n\t|\t\t\t\t\t  | \\ _ /\n\t|\t\t\t\t\t  |  |_|\n\t|_____________________|_/"); 
 

    System.out.println("\n[" + slots[0] + "][" + slots[1] + "][" + slots[1] + "]");

    try {
      Thread.sleep(200);
    } catch (Exception e) {
    }
  }

  //Randomize the slots
  public void randomize() {
    for (int i = 0 ; i < 3 ; i++) {
      slots[i] = types[rd.nextInt(5)];
    }
  }
  
  public Player returnPlayer() {
    return this.p;
  }
}