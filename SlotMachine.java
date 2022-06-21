public class SlotMachine extends Game {
  private Player p;

  public void startGame(Player p) {
    this.p = p;

    this.p.addSubMoney(9999);

  }

  public Player returnPlayer() {
    return this.p;
  }

  public String gameName() {
    return "Slot Machine";
  }
}