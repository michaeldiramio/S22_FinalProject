import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
	  System.out.println("---------WELCOME---------" + "\n" + "this is the Ultimate Card Game Center, in here you will find amazing card games and even games that you can use your money!" + "\n\n" + "Press Enter key to join the Ultimate Card Game Center");
    System.out.println("NDFLKQ");
    String pressEnter = sc.nextLine();

    if (pressEnter.equals("")){
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
    }

    Game g1 = new Guts();

    g1.startGame();


    
    
	}
}