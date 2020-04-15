package game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
/***
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Opponent extends Player
{
	double money;

	@Override
	public boolean determineHit() {
		// will use some ai/logic to determine somewhat randomly if the opponent should hit
		return false;
	}

	@Override
	public void removeMoney() {
		// removes cash from the opponent's money
		
	}

	@Override
	public void addMoney() {
		// adds cash to the opponent's money
		
	}

	@Override
	public double getMoney() {
		// gets the amount of cash
		return 0;
	}

}