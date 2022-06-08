public class Player {
	private String name;
	private int money;
	private int id;

	public Player (String name, int money, int id) {
		this.name = name;
		this.money = money;
		this.id = id;
	}

	public String getName() { //gets name
		return this.name;
	} 

	public int getMoney() { //gets money 
		return this.money;
	}

	public int getID() { //gets id
		return this.id;
	} 

	public void addSubMoney(int i) {		//change money by i amount
		this.money = money + i; 
	}
}