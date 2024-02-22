package com.example.customers.utils;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
	@Test
	public void looses_when_dice_number_is_too_low() {

		//Mockito se utiliza cuando quieres simular un resultado es decir cuando el resultado son numeros aleatorio o no sabes el resultado
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(2);
		//Dice dice = new Dice(6);
		Player player = new Player(dice, 3);
		assertFalse(player.play());
	}
	@Test
	public void wins_when_dice_number_is_big() {

		//Mockito se utiliza cuando quieres simular un resultado es decir cuando el resultado son numeros aleatorio o no sabes el resultado
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(4);
		//Dice dice = new Dice(6);
		Player player = new Player(dice, 3);
		assertTrue(player.play());
	}
}