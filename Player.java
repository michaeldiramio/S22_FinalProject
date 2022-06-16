public class Player {
	private String name;
	private int money;
	private int pin;

	public Player (String name, int money, int pin) {
		this.name = name;
		this.money = money;
		this.pin = pin;
	}

	public String getName() { //gets name
		return this.name;
	} 

	public int getBalance() { //gets money 
		return this.money;
	}

	public int getPin() { //gets id
		return this.pin;
	} 

	public void addSubMoney(int i) {		//change money by i amount
		this.money = money + i; 
	}

  //Converts the player to a string
  public String toString() {
    String s = new String(this.name + "," + this.money + "," + this.pin);

    return s;
  }
}