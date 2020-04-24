package game;
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

	public boolean determineHit() 
	{
		boolean shallHit = false;
		Random rand = new Random();
		
		int probHit = (21 - determineHandValue()) * (100/21); // The higher the card value, the less the probability
		int probMod = 0;
		
		//Money considered as factor
		//High thousands
		if (money >= 5000) 
		{
			probMod = 100;
		}
		//low thousands, decreases likeliness by 15%
		else if (money <= 4999 && money >= 1000) 
		{
			probMod = 85;
		}
		//high hundreds, decreases likeliness by 25%
		else if (money <= 999 && money >= 500) 
		{
			probMod = 75;
		}
		//low hundreds, decreases likeliness by 50%
		else if (money <= 499 && money >= 100) 
		{
			probMod = 50;
		}
		//below 100, decreases likeliness by 75%
		else if (money <= 99 && money >= 1) 
		{
			probMod = 25;
		}
		//debt or no money
		else if (money <= 0) 
		{
			shallHit = false;
			return shallHit; //withdrawl
		}
		
		//probMod is multiplied to the probHit to factor in both probabilities equally
		probHit *= probMod;
		
		int d100 = rand.nextInt(10);
		if (d100 <= probHit) 
		{
			shallHit = true;
		}
		else 
		{
			shallHit = false;
			return shallHit;
		}
		
		return shallHit;
	}


	@Override
	public void removeMoney(double amt) 
	{
		// removes cash from the opponent's money
		
	}

	@Override
	public void addMoney(double amt) 
	{
		// adds cash to the opponent's money
		
	}

	@Override
	public double getMoney() 
	{
		// gets the amount of cash
		return 0;
	}

}