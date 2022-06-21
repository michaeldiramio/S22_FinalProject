public class Game {
  private Player p;
  
  //Starting the game
  public void startGame (Player p) {
    this.p = p;
    System.out.println("huh");
  }

  public Player returnPlayer () {
    return this.p;
  }

  public String gameName(){
    return "huh";
  }
}