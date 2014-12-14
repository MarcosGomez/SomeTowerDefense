package Model;

import java.util.Observable;

import View.ResourcePanel;

public class Player extends Observable {

	private static Player player;
	private int money;

	// private ResourcePanel resource = ResourcePanel.getInstance();

	private Player() {
		money = 500;
	//	addObserver(ResourcePanel.getInstance());
	}

	public static Player getInstance() {
		if (player == null)
			player = new Player();
		return player;
	}

	public void addMoney(int add) {
		money += add;
		setChanged();
		notifyObservers();
	}

	public boolean subtractMoney(int subtract) {
		if (money - subtract < 0)
			return false;
		money -= subtract;
		setChanged();
		notifyObservers();
		return true;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
