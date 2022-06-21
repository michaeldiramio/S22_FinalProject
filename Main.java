import java.util.Scanner;

import java.util.ArrayList;

import java.io.File;
import java.io.PrintStream;

public class Main {
  ArrayList<Player> players = new ArrayList<Player>();

  public void run() {
    // Scanner
    Scanner sc = new Scanner(System.in);

    // Load players from file into players array
    loadFile();

    // Valid pin
    boolean validPin = false;
    // The player you will use
    Player activePlayer = new Player("", 0, 0);

    System.out.println("---------WELCOME---------\n"
        + "This is the Ultimate Card Game Center, in here you will find amazing card games!"
        + "\n\n" + "Press Enter key to join the game center");

    String pressEnter = sc.nextLine();

    if (pressEnter.equals("")) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    // Asking for player name
    System.out.print("Please enter your name: ");
    String playerName = sc.nextLine();

    // Variable to see if the player name exists
    boolean exists = false;
    for (int i = 0; i < players.size() && exists == false; i++) {
      // If the player exists
      if (playerName.equals(players.get(i).getName())) {
        exists = true;
        // Use the player from the array
        activePlayer = players.get(i);

        // Get the player to enter the pin that goes with their profile
        while (validPin == false) {
          try {
            System.out.println("Welcome back " + activePlayer.getName() + "!\nEnter your player pin to login");
            int pin = sc.nextInt();
            sc.nextLine();

            validPin = true;

            // Incorrect pin
            if (pin != activePlayer.getPin()) {
              validPin = false;
              System.out.println("That pin is incorrect");
            }
          } catch (Exception e) {
            System.out.println("Your pin is an integer");
            sc.nextLine();
          }
        }
      }
    }

    // If player does not exist
    if (exists == false) {
      // Get the player to make a unique pin for their profile
      while (validPin == false) {
        try {
          System.out.print("Enter an ID for your player: ");
          int pin = sc.nextInt();
          sc.nextLine();
          validPin = true;

          // Existing pin
          for (int i = 0; i < players.size() && validPin == true; i++) {
            if (pin == players.get(i).getPin()) {
              validPin = false;
              System.out.println("That pin already exists");
            }
          }

          // Pin does not exists
          if (validPin == true) {
            // Create a new player and use that pin
            activePlayer = new Player(playerName, 1000, pin);
            players.add(activePlayer);
          }
        } catch (Exception e) {
          System.out.println("Pin must be an integer");
          sc.nextLine();
        }
      }
    }

    //While playing
    boolean playing = true;
    while (playing == true) {
      // array of games
      ArrayList<Game> games = new ArrayList<Game>();
      Game blackJack = new blkJack();
      games.add(blackJack);
      Game guts = new Guts();
      games.add(guts);
      Game coinFlip = new CoinFlip();
      games.add(coinFlip);
      Game roulette = new Roulette();
      games.add(roulette);
      Game slotMachine = new SlotMachine();
      games.add(slotMachine);

      System.out.print("\033[H\033[2J");
      System.out.flush();

      System.out.println(activePlayer.getName() + "\t\t\tBalance: $" + activePlayer.getBalance() + "\n");

      //Printing choices
      for (int i = 1; i <= games.toArray().length; i++) {
        System.out.println(games.get(i - 1).gameName() + " - " + i);
      }

      //Getting choice from player
      int gameChoice = 0;
      boolean validGame = false;
      while (validGame == false) {
        try {
          gameChoice = sc.nextInt();
          
          if (gameChoice >= 1 && gameChoice <= games.toArray().length) {
            validGame = true;
          } else {
            System.out.println("Not a valid game choice");
          }
        } catch (Exception e) {
          System.out.println("Game choice must be an integer");
          sc.nextLine();
        }
      }

      //What each selection does
      if (gameChoice == 1) {
        System.out.println("You chose " + games.get(0).gameName());
        games.get(0).startGame(activePlayer);
      } else if (gameChoice == 2) {
        System.out.println("You chose " + games.get(1).gameName());
        games.get(1).startGame(activePlayer);
      } else if (gameChoice == 3) {
        System.out.println("You chose " + games.get(2).gameName());
        games.get(2).startGame(activePlayer);
      } else if (gameChoice == 4) {
        System.out.println("You chose " + games.get(3).gameName());
        games.get(3).startGame(activePlayer);
      } else if (gameChoice == 5) {
        System.out.println("You chose " + games.get(4).gameName());
        games.get(4).startGame(activePlayer);
      } else if (gameChoice == 6) {
        System.out.println("You chose " + games.get(5).gameName());
        games.get(5).startGame(activePlayer);
      }


      //Stop playing (Temporary)
      playing = false;
    }
    
    //Do you want to save your progress?
    String save = new String("");
    while (!save.equalsIgnoreCase("y") && !save.equalsIgnoreCase("n")) {
      System.out.println("Would you like to save your players progress?\ny/n");
      save = sc.nextLine();

      if (save.equalsIgnoreCase("y")) {
        saveToFile();
        save.equalsIgnoreCase("[SAVED TO FILE]");
      }
    }
    sc.close();
  }

  // Load players from the file into an array
  public void loadFile() {
    try {
      Scanner fileSC = new Scanner(new File("players.txt"));

      while (fileSC.hasNextLine()) {
        this.players.add(toPlayer(fileSC.nextLine()));
      }

      fileSC.close();
    } catch (Exception e) {
    }

  }

  // Converting string from file into a player
  public Player toPlayer(String line) {
    String[] split = line.split(",");
    Player player = new Player(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));

    return player;
  }

  // Save the updated player array to the file
  public void saveToFile() {
    try {
      PrintStream ps = new PrintStream(new File("players.txt"));

      for (int i = 0; i < this.players.size(); i++) {
        ps.println(this.players.get(i).toString());
      }

      ps.close();
    } catch (Exception e) {
    }
  }

  public static void main(String[] args) {
    Main m = new Main();
    m.run();
  }
}
