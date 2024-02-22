package com.example.customers.utils;

public class Player {
	private Dice dice;
	private int minNumberTowin;

	public Player(Dice dice, int minNumberTowin) {
		this.dice = dice;
		this.minNumberTowin = minNumberTowin;
	}

	public boolean play() {
		int diceNumbers = dice.roll();

		return diceNumbers >= this.minNumberTowin;
	}
}
